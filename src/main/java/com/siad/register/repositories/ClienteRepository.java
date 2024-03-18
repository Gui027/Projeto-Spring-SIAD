package com.siad.register.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siad.register.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
  List<Cliente> findByAtivoTrue();
}
