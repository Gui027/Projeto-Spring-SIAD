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

import com.siad.register.DTO.RequestFisicoDTO;
import com.siad.register.models.Fisico;
import com.siad.register.repositories.FisicoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.NonNull;

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

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<Fisico> updateFisico(@PathVariable @NonNull Long id,
      @RequestBody @Valid RequestFisicoDTO data) {
    Optional<Fisico> optionalFisico = repository.findById(id);
    if (optionalFisico.isPresent()) {
      Fisico fisico = optionalFisico.get();
      fisico.setNome(data.nome());
      fisico.setCpf(data.cpf());
      fisico.setUf(data.uf());
      fisico.setCidade(data.cidade());
      fisico.setBairro(data.bairro());
      fisico.setNumero(data.numero());
      fisico.setDataNascimento(data.dataNascimento());
      return ResponseEntity.status(HttpStatus.OK).body(fisico);
    }
    return ResponseEntity.noContent().build();
  }
}
