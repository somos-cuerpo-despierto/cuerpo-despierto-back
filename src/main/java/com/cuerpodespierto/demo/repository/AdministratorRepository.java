package com.cuerpodespierto.demo.repository;

import com.cuerpodespierto.demo.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Optional<Administrator> findByUsername(String username);
}