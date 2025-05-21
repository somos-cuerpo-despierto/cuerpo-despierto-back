package com.cuerpodespierto.demo.repository;

import com.cuerpodespierto.demo.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaseRepository  extends JpaRepository<Clase, Long> {
    
    
}
