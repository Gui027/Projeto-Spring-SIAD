package com.siad.register.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siad.register.DTO.RequestContatoDTO;
import com.siad.register.models.Contato;
import com.siad.register.repositories.ContatoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.NonNull;

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

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<Contato> updateContato(@PathVariable @NonNull Long id,
      @RequestBody @Valid RequestContatoDTO data) {
    Optional<Contato> optionalContato = repository.findById(id);
    if (optionalContato.isPresent()) {
      Contato contato = optionalContato.get();
      contato.setDescricao(data.descricao());
      contato.setNumero(data.numero());
      return ResponseEntity.status(HttpStatus.OK).body(contato);
    }
    return ResponseEntity.noContent().build();
  }
}