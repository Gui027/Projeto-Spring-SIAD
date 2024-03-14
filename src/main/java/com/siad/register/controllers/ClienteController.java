package com.siad.register.controllers;

import com.siad.register.models.Cliente;
import com.siad.register.repositories.ClienteRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
  @Autowired
  private ClienteRepository repository;

  @GetMapping
  public ResponseEntity<List<Cliente>> getAllClientes() {
    var allClientes = repository.findAll();
    return ResponseEntity.ok(allClientes);
  }
}
