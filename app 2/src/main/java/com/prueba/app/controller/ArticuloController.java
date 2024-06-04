package com.prueba.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.app.exception.ResourceNotFoundException;
import com.prueba.app.model.Articulo;
import com.prueba.app.service.ArticuloService;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {
    
    private final ArticuloService articuloService;

    @Autowired
    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping
    public List<Articulo> getAllArticulos() {
        return articuloService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Articulo> getArticuloById(@PathVariable Long id) {
        return articuloService.findById(id);
    }

    @PostMapping
    public Articulo createArticulo(@RequestBody Articulo articulo) {
        return articuloService.save(articulo);
    }

    @PutMapping("/{id}")
    public Articulo updateArticulo(@PathVariable Long id, @RequestBody Articulo articuloDetails) {
        Articulo articulo = articuloService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Artículo no encontrado con id " + id));
        articulo.setCodigo(articuloDetails.getCodigo());
        articulo.setNombre(articuloDetails.getNombre());
        articulo.setPrecioUnitario(articuloDetails.getPrecioUnitario());
        articulo.setStock(articuloDetails.getStock());
        return articuloService.save(articulo);
    }

    @DeleteMapping("/{id}")
    public void deleteArticulo(@PathVariable Long id) {
        articuloService.deleteById(id);
    }
}
