package com.mrdevv.payload.dto.usuario;

public record ResponseUsuarioSimpleDTO(
        Long id,
        String nombres,
        String apellidos
) {
}
