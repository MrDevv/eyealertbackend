package com.mrdevv.payload.dto.quizz;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponsePuntajeUsuario(
        @JsonProperty("puntaje_mas_alto")
        Integer puntajeMasAlto,
        @JsonProperty("ultimo_puntaje")
        Integer ultimoPuntaje
) {
}
