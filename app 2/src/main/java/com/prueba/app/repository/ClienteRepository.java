package com.prueba.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.app.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
