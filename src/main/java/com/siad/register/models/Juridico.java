package com.siad.register.models;

import java.time.LocalDate;

import com.siad.register.DTO.RequestJuridicoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "juridico")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Juridico extends Cliente {

  private String cnpj;

  private String ie;

  public Juridico(String cnpj, String ie, Long id, String nome,
      LocalDate dataNascimento, boolean ativo, Empresa empresa) {
    super(id, nome, dataNascimento, ativo, empresa);
    this.ie = ie;
    this.cnpj = cnpj;

  }

  // @OneToMany(mappedBy = "juridico", cascade = CascadeType.ALL, fetch =
  // FetchType.LAZY)
  // private List<Contato> contatos;

  public Juridico(RequestJuridicoDTO requestJuridicoDTO) {
    this.cnpj = requestJuridicoDTO.cnpj();
    this.ie = requestJuridicoDTO.ie();
    this.nome = requestJuridicoDTO.nome();
    this.id = requestJuridicoDTO.id();
    this.dataNascimento = requestJuridicoDTO.dataNascimento();
    this.ativo = true;
    this.empresa = requestJuridicoDTO.empresa();
  }
}
