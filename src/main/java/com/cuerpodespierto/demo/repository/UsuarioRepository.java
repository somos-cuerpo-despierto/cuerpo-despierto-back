package com.cuerpodespierto.demo.repository;

import com.cuerpodespierto.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  
    Usuario findByUsername(String username);
}
