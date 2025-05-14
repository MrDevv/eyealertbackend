package com.mrdevv.payload.dto.usuario;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ResponseUsuarioDTO(
        Long id,
        String nombres,
        String apellidos,
        String email,
        String rol,
        Boolean cuestionarioCompleado,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fecha
) {

}

