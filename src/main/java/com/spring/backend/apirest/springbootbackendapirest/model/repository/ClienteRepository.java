package com.spring.backend.apirest.springbootbackendapirest.model.repository;

import com.spring.backend.apirest.springbootbackendapirest.model.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
