package com.siad.register.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siad.register.DTO.RequestJuridicoDTO;
import com.siad.register.models.Juridico;
import com.siad.register.repositories.JuridicoRepository;

@RestController
@RequestMapping("/juridico")
public class JuridicoController {
  @Autowired
  private JuridicoRepository repository;

  @GetMapping
  public ResponseEntity<List<Juridico>> getAllJuridicos() {
    var allJuridicos = repository.findAll();
    return ResponseEntity.ok(allJuridicos);
  }

  @PostMapping
  public ResponseEntity<Juridico> createJuridico(@RequestBody RequestJuridicoDTO novoJuridico) {
    Juridico juridico = new Juridico(novoJuridico);
    repository.save(juridico);
    return ResponseEntity.ok(juridico);
  }
}
