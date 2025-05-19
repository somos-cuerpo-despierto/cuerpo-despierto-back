package com.cuerpodespierto.demo.service;

import com.cuerpodespierto.demo.model.Clase;
import java.util.List;

public interface ClaseService {
    
    List<Clase> getAllClases();

    Clase getClaseById(long id);

    Clase createClase(Clase clase);

    Clase updateClase(long id, Clase clase);

    void deleteClase(long id);
}
