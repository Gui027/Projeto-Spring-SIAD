package com.siad.register.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.InheritanceType;

@Entity
@Table(name = "cliente")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public abstract class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected Long id;

  protected String nome;

  protected LocalDate dataNascimento;

  protected boolean ativo; // considere usar o tipo primitivo boolean ao invés do wrapper Boolean. Isso
  // pode evitar NullPointerException em cenários onde o valor não é
  // essencialmente nulo. Use Boolean se houver uma necessidade real de
  // representar três estados (true, false, null).

  @ManyToOne
  @JoinColumn(name = "empresa_id") // Chave estrangeira
  protected Empresa empresa;

}
