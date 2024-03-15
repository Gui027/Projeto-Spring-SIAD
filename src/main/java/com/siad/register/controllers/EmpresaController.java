package com.siad.register.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.siad.register.DTO.RequestEmpresaDTO;
import com.siad.register.models.Empresa;
import com.siad.register.repositories.EmpresaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.NonNull;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
  @Autowired
  private EmpresaRepository repository;

  @GetMapping
  public ResponseEntity<List<Empresa>> getAllEmpresa() {
    var allEmpresa = repository.findAll();
    return ResponseEntity.ok(allEmpresa);
  }

  @PostMapping
  public ResponseEntity<Empresa> createEmpresa(@RequestBody RequestEmpresaDTO novaEmpresa) {
    Empresa empresa = new Empresa(novaEmpresa);
    repository.save(empresa);
    return ResponseEntity.ok(empresa);
  }

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<Empresa> updateEmpresa(@PathVariable @NonNull Long id,
      @RequestBody @Valid RequestEmpresaDTO data) {
    Optional<Empresa> optionalEmpresa = repository.findById(id);
    if (optionalEmpresa.isPresent()) {
      Empresa empresa = optionalEmpresa.get();
      empresa.setNome(data.nome());
      return ResponseEntity.status(HttpStatus.OK).body(empresa);
    }
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  @Transactional
  @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna 204 em caso de sucesso
  public void deleteContato(@PathVariable @NonNull Long id) {
    repository.deleteById(id);
  }
}
