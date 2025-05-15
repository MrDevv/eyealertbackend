package com.mrdevv.payload.dto.evaluacion;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mrdevv.payload.dto.detalleEvaluacion.CreateDetailEvaluationDTO;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record CreateEvaluationDTO(
        @NotNull(message = "El tiempo de predicción es obligatorio")
        @JsonProperty("tiempo_prediccion")
        Double tiempoPrediccion,

        @NotNull(message = "El tiempo de predicción inicio es obligatorio")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
        @JsonProperty("tiempo_prediccion_inicio")
        LocalDateTime tipoPrediccionInicio,

        @NotNull(message = "El tiempo de predicción fin es obligatorio")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
        @JsonProperty("tiempo_prediccion_fin")
        LocalDateTime tipoPrediccionFin,

        @NotNull(message = "El resultado de la evaluación es obligatorio")
        Integer resultado,

        @NotNull(message = "El id del usuario es obligatorio")
        @JsonProperty("usuario_id")
        Long usuarioId,

        @JsonProperty("detalle_evaluacion")
        List<CreateDetailEvaluationDTO> detallesEvaluacion
) {
}
