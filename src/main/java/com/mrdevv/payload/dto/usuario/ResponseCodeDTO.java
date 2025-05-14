package com.mrdevv.payload.dto.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseCodeDTO(
        Integer code,
        @JsonProperty("usuario_id")
        Long usuarioId
) {
}
