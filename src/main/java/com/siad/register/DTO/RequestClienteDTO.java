package com.siad.register.DTO;

import java.time.LocalDate;

public record RequestClienteDTO(
    Long id,
    String nome,
    LocalDate dataNascimento) {
}
