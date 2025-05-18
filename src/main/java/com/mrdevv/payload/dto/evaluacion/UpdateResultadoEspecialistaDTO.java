package com.mrdevv.payload.dto.evaluacion;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateResultadoEspecialistaDTO(
        @JsonProperty("resultado_especialista")
        Boolean resultadoEspecialista
){}
