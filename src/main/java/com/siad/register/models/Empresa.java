package com.siad.register.models;

import com.siad.register.DTO.RequestEmpresaDTO;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "empresa")
public class Empresa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  private boolean ativo; // considere usar o tipo primitivo boolean ao invés do wrapper Boolean. Isso
                         // pode evitar NullPointerException em cenários onde o valor não é
                         // essencialmente nulo. Use Boolean se houver uma necessidade real de
                         // representar três estados (true, false, null).

  // @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY) // Mapeando pelo
  // campo 'empresa' na entidade Cliente // o
  // // fetch type para LAZY para melhorar a performance, evitando
  // // carregar dados desnecessariamente.
  // private List<Cliente> clientes = new ArrayList<>();

  public Empresa(RequestEmpresaDTO requestEmpresaDTO) {
    this.nome = requestEmpresaDTO.nome();
    this.ativo = true;
  }

}
