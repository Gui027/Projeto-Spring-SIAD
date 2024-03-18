package com.siad.register.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.siad.register.models.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
  List<Contato> findByAtivoTrue(); // Metodo que o Spring Data JPA interpretará automaticamente para buscar
                                   // contatos onde o campo ativo é true.

  List<Contato> findByJuridicoId(Long juridicoId); // Método para encontrar contatos por ID do cliente

  @Query("SELECT c FROM Contato c WHERE c.ativo = true AND c.juridico.ativo = true")
  List<Contato> findAtivosComClientesAtivos();
}
