package com.cuerpodespierto.demo.service;

import com.cuerpodespierto.demo.model.Administrator;
import com.cuerpodespierto.demo.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public List<Administrator> findAll() {
        return administratorRepository.findAll();
    }

    public Optional<Administrator> findById(Long id) {
        return administratorRepository.findById(id);
    }

    public Administrator save(Administrator admin) {
        return administratorRepository.save(admin);
    }

    public void deleteById(Long id) {
        administratorRepository.deleteById(id);
    }

    public Administrator update(Long id, Administrator updatedAdmin) {
        return administratorRepository.findById(id)
                .map(existingAdmin -> {
                    existingAdmin.setUsername(updatedAdmin.getUsername());
                    existingAdmin.setPassword(updatedAdmin.getPassword());
                    return administratorRepository.save(existingAdmin);
                })
                .orElseThrow(() -> new RuntimeException("Administrator not found with id: " + id));
    }
}