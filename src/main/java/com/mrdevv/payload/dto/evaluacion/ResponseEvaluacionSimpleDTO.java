package com.mrdevv.payload.dto.evaluacion;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record ResponseEvaluacionSimpleDTO(
        Long id,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        Date fecha,
        @JsonProperty("tiempo_prediccion")
        Integer tiempoPrediccion,
        String resultado
) {
}
