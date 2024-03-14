package com.siad.register.DTO;

import com.siad.register.models.Juridico;

public record RequestContatoDTO(
        Long id,
        String descricao,
        String numero,
        Juridico juridico) {
}
