package com.spring.backend.apirest.springbootbackendapirest.model.service.interfaces;


import com.spring.backend.apirest.springbootbackendapirest.model.domain.Cliente;
import com.spring.backend.apirest.springbootbackendapirest.model.utilities.MyResponseUtility;
public interface ClienteServiceInterface {

    MyResponseUtility findAll();
    MyResponseUtility finById(Long id);

    MyResponseUtility save(Cliente cliente);

    MyResponseUtility delete(Long id);

    MyResponseUtility update(Cliente cliente, Long id);
}
