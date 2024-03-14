package com.siad.register.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import com.siad.register.DTO.RequestContatoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contato")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contato {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String descricao;

  @Column(nullable = false)
  private String numero;

  @Column(nullable = false)
  private boolean ativo;

  @ManyToOne
  @JoinColumn(name = "juridico_id", nullable = false)
  private Juridico juridico;

  public Contato(RequestContatoDTO requestContatoDTO) {
    this.ativo = true;
    this.id = requestContatoDTO.id();
    this.descricao = requestContatoDTO.descricao();
    this.numero = requestContatoDTO.numero();
    this.juridico = requestContatoDTO.juridico();
  }
}
