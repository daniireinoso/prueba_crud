package com.prueba.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.app.model.Articulo;
import com.prueba.app.repository.ArticuloRepository;

@Service
public class ArticuloService {
     private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    public List<Articulo> findAll() {
        return articuloRepository.findAll();
    }

    public Optional<Articulo> findById(Long id) {
        return articuloRepository.findById(id);
    }

    public Articulo save(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    public void deleteById(Long id) {
        articuloRepository.deleteById(id);
    }
}
