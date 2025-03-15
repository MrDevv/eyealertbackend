package com.mrdevv.payload.dto.respuesta;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseRespuestasDTO(
        @JsonProperty("respuesta_id")
        Long id,
        String respuesta
){}