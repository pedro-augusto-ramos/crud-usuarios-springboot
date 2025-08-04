package com.pedroramos.crudusuarios.controller;

import com.pedroramos.crudusuarios.exception.InvalidDataException;
import com.pedroramos.crudusuarios.model.Usuario;
import com.pedroramos.crudusuarios.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<?> criarUsuario (@RequestBody Usuario usuario){
        Usuario novoUsuario;
        try {
            novoUsuario = service.salvarUsuario(usuario);
        } catch (InvalidDataException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }

        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> buscarTodosUsuarios (){
        List<Usuario> usuarios;
        try {
            usuarios = service.buscarTodos();
        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId (@PathVariable Long id){
        Usuario usuarioAchado;
        try {
            usuarioAchado = service.buscarPorId(id);
        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok().body(usuarioAchado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarUsuarioPorId (@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioAtualizado;
        try{
            usuarioAtualizado = service.atualizarPorId(id, usuario);
        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (InvalidDataException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().body(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuarioPorId (@PathVariable Long id){
        try {
            service.deletarPorId(id);
        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.accepted().build();
    }

}
