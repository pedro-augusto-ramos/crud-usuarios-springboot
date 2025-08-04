package com.pedroramos.crudusuarios.repository;

import com.pedroramos.crudusuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
}
