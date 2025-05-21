package com.cuerpodespierto.demo.service.impl;

import com.cuerpodespierto.demo.model.Reserva;
import com.cuerpodespierto.demo.repository.ReservaRepository;
import com.cuerpodespierto.demo.service.ReservaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public Reserva crearReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> getReservasByUsuario(Long usuarioId) {
        // Implementa este método según tus necesidades
        return reservaRepository.findAll(); // Solo ejemplo
    }
}
