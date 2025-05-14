package com.mrdevv.payload.dto.cuestionarioConocimientos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseConfigCuestionarioDTO(
        Long id,
        @JsonProperty("dias_espera")
        Integer diasEspera
){}
