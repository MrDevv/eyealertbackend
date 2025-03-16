package com.mrdevv.payload.dto.usuario;

public record ResponseUsuarioDTO(
        Long id,
        String nombres,
        String apellidos,
        String email,
        String rol
) {

}

