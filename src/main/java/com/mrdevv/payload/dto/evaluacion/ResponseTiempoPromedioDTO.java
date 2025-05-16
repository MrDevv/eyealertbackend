package com.mrdevv.payload.dto.evaluacion;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseTiempoPromedioDTO(
        @JsonProperty("total_evaluaciones")
        Integer totalEvaluaciones,
        @JsonProperty("tiempo_promedio_prediccion")
        Double tiempoPromedio
) {
}
