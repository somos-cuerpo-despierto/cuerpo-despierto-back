package com.cuerpodespierto.demo.repository;

import com.cuerpodespierto.demo.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {}
