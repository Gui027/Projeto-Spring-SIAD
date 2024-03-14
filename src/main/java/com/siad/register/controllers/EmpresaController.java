package com.siad.register.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.siad.register.DTO.RequestEmpresaDTO;
import com.siad.register.models.Empresa;
import com.siad.register.repositories.EmpresaRepository;

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
}
