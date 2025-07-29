package com.mrdevv.payload.dto.quizz;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ResponsePreguntaQuizzDTO(
        @JsonProperty("pregunta_id")
        Long preguntaId,
        String pregunta,
        String categoria,
        @JsonProperty("respuestas")
        List<ResponseRespuestaQuizz> respuestaQuizzes
) {
}
