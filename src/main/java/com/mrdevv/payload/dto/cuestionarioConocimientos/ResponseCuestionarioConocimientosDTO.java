package com.mrdevv.payload.dto.cuestionarioConocimientos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mrdevv.payload.dto.usuario.ResponseUsuarioSimpleDTO;

import java.time.LocalDateTime;

public record ResponseCuestionarioConocimientosDTO(
        Long id,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fecha,
        String usuario,
        @JsonProperty("puntaje_total")
        Integer puntateTotal
) {
}
