package com.cuerpodespierto.demo.controller;

import com.cuerpodespierto.demo.model.Clase;
import com.cuerpodespierto.demo.service.ClaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
@CrossOrigin(origins = "*")
public class ClaseController {

    private final ClaseService claseService;

    public ClaseController(ClaseService claseService) {
        this.claseService = claseService;
    }

    @GetMapping
    public List<Clase> getAllClases() {
        return claseService.getAllClases();
    }

    @PostMapping
    public ResponseEntity<Clase> createClase(@RequestBody Clase clase) {
        Clase nuevaClase = claseService.createClase(clase);
        return new ResponseEntity<>(nuevaClase, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clase> getClaseById(@PathVariable Long id) {
        Clase clase = claseService.getClaseById(id);
        if (clase == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clase, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clase> updateClase(@PathVariable Long id, @RequestBody Clase clase) {
        Clase claseActualizada = claseService.updateClase(id, clase);
        if (claseActualizada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(claseActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClase(@PathVariable Long id) {
        Clase clase = claseService.getClaseById(id);
        if (clase == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        claseService.deleteClase(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



