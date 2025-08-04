package com.pedroramos.crudusuarios.service;

import com.pedroramos.crudusuarios.exception.InvalidDataException;
import com.pedroramos.crudusuarios.model.Usuario;
import com.pedroramos.crudusuarios.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario salvarUsuario(Usuario usuario){
        verificarUsuario(usuario);
        return repository.save(usuario);
    }

    public List<Usuario> buscarTodos(){

        List<Usuario> usuarios = repository.findAll();

        if(usuarios.isEmpty()){
            throw new EntityNotFoundException("Não há usuários cadastrados no banco de dados");
        }

        return usuarios;
    }

    public Usuario buscarPorId (Long id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não há usuários com Id " + id + " no banco de dados"));
    }

    public Usuario atualizarPorId (Long id, Usuario usuario){
        Usuario usuarioAntigo = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não há usuários com Id " + id + " no banco de dados"));

        verificarUsuario(usuario);

        usuarioAntigo.setEmail(usuario.getEmail());
        usuarioAntigo.setNome(usuario.getNome());
        usuarioAntigo.setIdade(usuario.getIdade());
        return repository.save(usuarioAntigo);
    }

    public void deletarPorId(Long id){

        if(repository.findById(id).isEmpty()){
            throw new EntityNotFoundException("Não há usuários com Id " + id + " no banco de dados");
        }

        repository.deleteById(id);
    }

    public void verificarUsuario(Usuario usuario){
        if(usuario.getEmail() == null || usuario.getEmail().isBlank()){
            throw new InvalidDataException("Email é obrigatório");
        }

        if(usuario.getNome() == null || usuario.getNome().isBlank()){
            throw new InvalidDataException("Nome é obrigatório");
        }

        if(usuario.getIdade() == null){
            throw new InvalidDataException("Idade é obrigatório");
        }
    }

}
