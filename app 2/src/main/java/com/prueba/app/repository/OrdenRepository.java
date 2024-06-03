package com.prueba.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.app.model.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
    
}
