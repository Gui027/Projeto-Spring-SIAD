package com.siad.register.DTO;

import java.time.LocalDate;

import com.siad.register.models.Empresa;

public record RequestJuridicoDTO(
        String nome,
        Long id,
        String cnpj,
        String ie,
        LocalDate dataNascimento,
        Empresa empresa) {

}
