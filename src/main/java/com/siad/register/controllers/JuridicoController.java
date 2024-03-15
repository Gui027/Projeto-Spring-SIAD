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

import com.siad.register.DTO.RequestJuridicoDTO;
import com.siad.register.models.Juridico;
import com.siad.register.repositories.JuridicoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.NonNull;

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

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<Juridico> updateJuridico(@PathVariable @NonNull Long id,
      @RequestBody @Valid RequestJuridicoDTO data) {
    Optional<Juridico> optionalJuridico = repository.findById(id);
    if (optionalJuridico.isPresent()) {
      Juridico juridico = optionalJuridico.get();
      juridico.setNome(data.nome());
      juridico.setCnpj(data.cnpj());
      juridico.setIe(data.ie());
      juridico.setDataNascimento(data.dataNascimento());
      return ResponseEntity.status(HttpStatus.OK).body(juridico);
    }
    return ResponseEntity.noContent().build();
  }
}
