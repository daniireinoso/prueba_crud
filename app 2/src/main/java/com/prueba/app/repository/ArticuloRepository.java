package com.prueba.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.app.model.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    
}
