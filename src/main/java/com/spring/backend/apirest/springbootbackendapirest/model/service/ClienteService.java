package com.spring.backend.apirest.springbootbackendapirest.model.service;

import com.spring.backend.apirest.springbootbackendapirest.model.domain.Cliente;
import com.spring.backend.apirest.springbootbackendapirest.model.repository.ClienteRepository;
import com.spring.backend.apirest.springbootbackendapirest.model.service.interfaces.ClienteServiceInterface;
import com.spring.backend.apirest.springbootbackendapirest.model.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService implements ClienteServiceInterface {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MyResponseUtility response;
    @Override
    @Transactional(readOnly = true)
    public MyResponseUtility findAll() {
        response.restart();
        response.data = clienteRepository.findAll();
        response.status = HttpStatus.OK.value();
        return response;
    }
    @Override
    @Transactional(readOnly = true)
    public MyResponseUtility finById(Long id) {
        response.restart();
        response.data = clienteRepository.findById(id).orElse(null);
        response.status = HttpStatus.OK.value();
        return response;
    }

    @Override
    @Transactional
    public MyResponseUtility save(Cliente cliente) {
        response.restart();
        response.data = clienteRepository.save(cliente);
        response.status = HttpStatus.CREATED.value();
        return response;
    }

    @Override
    @Transactional
    public MyResponseUtility delete(Long id) {
        var clientDelete = clienteRepository.findById(id);
        response.restart();
        if (clientDelete.isPresent()){
            clienteRepository.deleteById(id);
            response.status = HttpStatus.OK.value();
            response.message = "Cliente eliminado";
            return response;
        }else {
            response.message = "Cliente no encontrado";
            response.status = HttpStatus.NOT_FOUND.value();
            return response;
        }


    }

    @Override
    public MyResponseUtility update(Cliente cliente, Long id) {
        var clientOld = clienteRepository.findById(id);
        response.restart();

        if (clientOld.isPresent()){
            clientOld.get().setNombre(cliente.getNombre());
            clientOld.get().setApellido(cliente.getApellido());
            clientOld.get().setEmail(cliente.getEmail());

            response.data = clienteRepository.save(clientOld.get());
            response.status = HttpStatus.CREATED.value();
            return response;
        }else {
            response.message = "Cliente no encontrado";
            response.status = HttpStatus.NOT_FOUND.value();
            return response;
        }
    }

}
