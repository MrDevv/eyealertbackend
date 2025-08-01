package com.mrdevv.payload.dto.quizz;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateQuizzDTO(
        Integer puntaje,
        @JsonProperty("usuario_id")
        Long usuarioId
) {
}
