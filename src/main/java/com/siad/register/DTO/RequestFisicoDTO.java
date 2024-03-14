package com.siad.register.DTO;

import java.time.LocalDate;

import com.siad.register.models.Empresa;

public record RequestFisicoDTO(
        String nome,
        Long id,
        String cpf,
        String uf,
        String cidade,
        String bairro,
        String numero,
        LocalDate dataNascimento,
        Empresa empresa) {

}
