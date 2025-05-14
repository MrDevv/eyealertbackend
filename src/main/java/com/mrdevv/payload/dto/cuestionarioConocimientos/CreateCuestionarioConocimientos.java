package com.mrdevv.payload.dto.cuestionarioConocimientos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CreateCuestionarioConocimientos(
        @JsonProperty("usuario_id")
        Long usuarioId,
        List<CreateRespuestaCuestionarioConocimientos> respuestas
) {
}
