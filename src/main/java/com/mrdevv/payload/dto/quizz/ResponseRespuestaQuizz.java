package com.mrdevv.payload.dto.quizz;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseRespuestaQuizz(
    @JsonProperty("respuesta_id")
    Long respuestaId,
    String respuesta,
    String explicacion,
    @JsonProperty("es_correcta")
    Boolean esCorrecta
) {
}
