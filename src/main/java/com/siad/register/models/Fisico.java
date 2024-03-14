package com.siad.register.models;

import java.time.LocalDate;

import com.siad.register.DTO.RequestFisicoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fisico")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Fisico extends Cliente {

  private String cpf;

  private String uf;

  private String cidade;

  private String bairro;

  private String numero;

  public Fisico(String cpf, String uf, String cidade, String bairro, String numero, Long id, String nome,
      LocalDate dataNascimento, boolean ativo, Empresa empresa) {
    super(id, nome, dataNascimento, ativo, empresa);
    this.bairro = bairro;
    this.cidade = cidade;
    this.numero = numero;
    this.uf = uf;
    this.cpf = cpf;

  }

  public Fisico(RequestFisicoDTO requestFisicoDTO) {
    this.cpf = requestFisicoDTO.cpf();
    this.uf = requestFisicoDTO.uf();
    this.cidade = requestFisicoDTO.cidade();
    this.bairro = requestFisicoDTO.bairro();
    this.numero = requestFisicoDTO.numero();
    this.nome = requestFisicoDTO.nome();
    this.id = requestFisicoDTO.id();
    this.dataNascimento = requestFisicoDTO.dataNascimento();
    this.ativo = true;
    this.empresa = requestFisicoDTO.empresa();
  }
}
