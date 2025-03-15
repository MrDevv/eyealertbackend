package com.mrdevv.payload.dto.evaluacion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mrdevv.payload.dto.detalleEvaluacion.CreateDetailEvaluation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateEvaluationDTO(
        @NotNull(message = "El tiempo de predicción es obligatorio")
        @JsonProperty("tiempo_prediccion")
        Double tiempoPrediccion,

        @NotNull(message = "El resultado de la evaluación es obligatorio")
        Integer resultado,

        @NotNull(message = "El id del usuario es obligatorio")
        @JsonProperty("usuario_id")
        Long usuarioId,

        @JsonProperty("detalle_evaluacion")
        List<CreateDetailEvaluation> detallesEvaluacion
) {
}
