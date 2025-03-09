package com.mrdevv.payload.dto.evaluacion;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ResponseEvaluacionesByUserDTO(
        @JsonProperty("id_usuario")
        Long idUsuario,
        String nombre,
        String apellido,
        List<ResponseEvaluacionSimpleDTO> evaluaciones
) {
}
