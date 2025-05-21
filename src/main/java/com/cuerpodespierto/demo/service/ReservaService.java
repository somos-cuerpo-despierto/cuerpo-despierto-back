package com.cuerpodespierto.demo.service;

import com.cuerpodespierto.demo.model.Reserva;
import java.util.List;

public interface ReservaService {
    Reserva crearReserva(Reserva reserva);
    List<Reserva> getReservasByUsuario(Long usuarioId);
}
