package com.siad.register.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siad.register.DTO.RequestFisicoDTO;
import com.siad.register.models.Fisico;
import com.siad.register.repositories.FisicoRepository;

@RestController
@RequestMapping("/fisico")
public class FisicoController {
  @Autowired
  private FisicoRepository repository;

  @GetMapping
  public ResponseEntity<List<Fisico>> getAllFisicos() {
    var allFisicos = repository.findAll();
    return ResponseEntity.ok(allFisicos);
  }

  @PostMapping
  public ResponseEntity<Fisico> createFisico(@RequestBody RequestFisicoDTO novoFisico) {
    Fisico fisico = new Fisico(novoFisico);
    repository.save(fisico);
    return ResponseEntity.ok(fisico);
  }
}
