package com.spring.backend.apirest.springbootbackendapirest.controller;

import com.spring.backend.apirest.springbootbackendapirest.model.domain.Cliente;
import com.spring.backend.apirest.springbootbackendapirest.model.service.ClienteService;
import com.spring.backend.apirest.springbootbackendapirest.model.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private MyResponseUtility response;
    @GetMapping("/clientes")
    public ResponseEntity<MyResponseUtility> findAll(){
        response = clienteService.findAll();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }
    @GetMapping("/clientes/{id}")
    public ResponseEntity<MyResponseUtility> findById(@PathVariable Long id){
        response = clienteService.finById(id);
        return new ResponseEntity<>(response,HttpStatus.valueOf(response.status));
    }
    @PostMapping("/clientes")
    public ResponseEntity<MyResponseUtility> save(@RequestBody Cliente cliente){
        response = clienteService.save(cliente);
        return new ResponseEntity<>(response,HttpStatus.valueOf(response.status));
    }
    @PutMapping("/clientes/{id}")
    public ResponseEntity<MyResponseUtility> update(@RequestBody Cliente cliente, @PathVariable Long id){
        response = clienteService.update(cliente, id);
        return new ResponseEntity<>(response,HttpStatus.valueOf(response.status));

    }
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<MyResponseUtility> delete(@PathVariable Long id){
        response = clienteService.delete(id);
        return new ResponseEntity<>(response,HttpStatus.valueOf(response.status));
    }
}
