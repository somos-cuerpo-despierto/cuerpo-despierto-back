package com.cuerpodespierto.demo.service.impl;

import com.cuerpodespierto.demo.model.Clase;
import com.cuerpodespierto.demo.repository.ClaseRepository;
import com.cuerpodespierto.demo.service.ClaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseServiceImpl implements ClaseService {

    private final ClaseRepository claseRepository;

    public ClaseServiceImpl(ClaseRepository claseRepository) {
        this.claseRepository = claseRepository;
    }

    @Override
    public List<Clase> getAllClases() {
        return claseRepository.findAll();
    }

    @Override
    public Clase getClaseById(long id) {
        Optional<Clase> clase = claseRepository.findById(id);
        return clase.orElse(null);
    }

    @Override
    public Clase createClase(Clase clase) {
        return claseRepository.save(clase);
    }

    @Override
    public Clase updateClase(long id, Clase clase) {
        if (!claseRepository.existsById(id)) {
            return null;
        }
        clase.setId(id);
        return claseRepository.save(clase);
    }

    @Override
    public void deleteClase(long id) {
        claseRepository.deleteById(id);
    }
}