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
import com.prueba.app.model.Orden;
import com.prueba.app.service.OrdenService;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    private final OrdenService ordenService;
    
    @Autowired
    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @GetMapping
    public List<Orden> getAllOrdenes() {
        return ordenService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Orden> getOrdenById(@PathVariable Long id) {
        return ordenService.findById(id);
    }

    @PostMapping
    public Orden createOrden(@RequestBody Orden orden) {
        return ordenService.save(orden);
    }

    @PutMapping("/{id}")
    public Orden updateOrden(@PathVariable Long id, @RequestBody Orden ordenDetails) {
         Orden orden = ordenService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Orden no encontrada con id " + id));
        orden.setCodigo(ordenDetails.getCodigo());
        orden.setFecha(ordenDetails.getFecha());
        return ordenService.save(orden);
    }

    @DeleteMapping("/{id}")
    public void deleteOrden(@PathVariable Long id) {
        ordenService.deleteById(id);
    }
}
