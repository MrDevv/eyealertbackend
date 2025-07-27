package com.mrdevv.payload.dto.quizz;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ResponseRankingDTO(
        List<PuestoUsuarioDTO> ranking,
        @JsonProperty("puesto_usuario")
        PuestoUsuarioDTO puestoUsuario
) {
}
