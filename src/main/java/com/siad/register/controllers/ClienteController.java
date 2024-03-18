package com.siad.register.controllers;

import com.siad.register.models.Cliente;
import com.siad.register.models.Contato;
import com.siad.register.repositories.ClienteRepository;
import com.siad.register.repositories.ContatoRepository;

import jakarta.transaction.Transactional;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
  @Autowired
  private ClienteRepository repository;

  @Autowired
  private ContatoRepository contatoRepository;

  @GetMapping
  public ResponseEntity<List<Cliente>> getAllClientes() {
    var allClientesAtivos = repository.findByAtivoTrue();
    return ResponseEntity.ok(allClientesAtivos);
  }

  @PutMapping("/desativar/{id}")
  @Transactional
  public ResponseEntity<Void> desativarCliente(@PathVariable @NonNull Long id) {
    Optional<Cliente> optionalCliente = repository.findById(id);
    if (optionalCliente.isPresent()) {
      Cliente cliente = optionalCliente.get();
      cliente.setAtivo(false);
      repository.save(cliente);

      // Desativa todos os contatos associados ao cliente
      List<Contato> contatosDoCliente = contatoRepository.findByJuridicoId(cliente.getId());
      for (Contato contato : contatosDoCliente) {
        contato.setAtivo(false);
        contatoRepository.save(contato);
      }
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
