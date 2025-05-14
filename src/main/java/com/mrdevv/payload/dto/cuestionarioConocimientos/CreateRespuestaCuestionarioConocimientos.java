package com.mrdevv.payload.dto.cuestionarioConocimientos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateRespuestaCuestionarioConocimientos(
        String pregunta,
        Character respuesta,
        @JsonProperty("puntaje_pregunta")
        Boolean puntajePregunta
) {
}
