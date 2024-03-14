package com.siad.register.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siad.register.DTO.RequestContatoDTO;
import com.siad.register.models.Contato;
import com.siad.register.repositories.ContatoRepository;

@RestController
@RequestMapping("/contato")
public class ContatoController {
  @Autowired
  private ContatoRepository repository;

  @GetMapping
  public ResponseEntity<List<Contato>> getAllContato() {
    var allContato = repository.findAll();
    return ResponseEntity.ok(allContato);
  }

  @PostMapping
  public ResponseEntity<Contato> createContato(@RequestBody RequestContatoDTO novoContato) {
    Contato contato = new Contato(novoContato);
    repository.save(contato);
    return ResponseEntity.ok(contato);
  }
}