package com.mrdevv.payload.dto.quizz;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PuestoUsuarioDTO(
        Integer puesto,
        @JsonProperty("usuario_id")
        Integer usuarioId,
        String nombres,
        Integer puntaje
) {
}
