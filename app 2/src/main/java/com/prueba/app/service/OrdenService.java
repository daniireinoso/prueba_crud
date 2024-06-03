package com.prueba.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.app.model.Orden;
import com.prueba.app.repository.OrdenRepository;

@Service
public class OrdenService {
 
    private final OrdenRepository ordenRepository;

    @Autowired
    public OrdenService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }

    public Optional<Orden> findById(Long id) {
        return ordenRepository.findById(id);
    }

    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }

    public void deleteById(Long id) {
        ordenRepository.deleteById(id);
    }
}
