package com.mrdevv.payload.dto.detalleEvaluacion;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record CreateDetailEvaluationDTO(
        @NotNull(message = "El id de la pregunta es obligatorio")
        @JsonProperty("pregunta_id")
        Long preguntaId,

        @JsonProperty("respuesta_id")
        Long respuestaId,

        @JsonProperty("respuesta_texto")
        String respuestaTexto
) {
}
