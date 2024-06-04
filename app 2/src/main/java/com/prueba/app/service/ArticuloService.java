package com.prueba.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
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

    public void actualizarStock(Long id, int cantidadVendida) {
        Articulo articulo = articuloRepository.findById(id).orElseThrow(() -> new RuntimeJsonMappingException("Articulo no encontrado"));
        int stockActual = articulo.getStock();
        if (stockActual < cantidadVendida) {
            throw new RuntimeJsonMappingException("no existe stock");
        } else {
            articulo.setStock(stockActual - cantidadVendida);
            articuloRepository.save(articulo);
        }
    }

    public boolean verificarStock(Long id, int cantidadDeseada) {
        Articulo articulo = articuloRepository.findById(id).orElseThrow(() -> new RuntimeJsonMappingException("Articulo no encontrado"));
        int stockActual = articulo.getStock();
        return stockActual >= cantidadDeseada;
    }

    public void agregarStock(Long id, int cantidadAgregar) {
        Articulo articulo = articuloRepository.findById(id).orElseThrow(() -> new RuntimeJsonMappingException("Articulo no encontrado"));
        int stockActual = articulo.getStock();
        if ((stockActual + cantidadAgregar) > 5) {
            throw new RuntimeJsonMappingException("no se puede agregar mas articulos");
        } else {
            articulo.setStock(stockActual + cantidadAgregar);
            articuloRepository.save(articulo);
        }
    }

    public void reducirStock(Long id, int cantidadAgregar) {
        Articulo articulo = articuloRepository.findById(id).orElseThrow(() -> new RuntimeJsonMappingException("Articulo no encontrado"));
        int stockActual = articulo.getStock();
        articulo.setStock(stockActual - cantidadAgregar);
        articuloRepository.save(articulo);
    }

}
