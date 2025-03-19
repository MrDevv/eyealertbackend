package com.mrdevv.payload.dto.usuario;

import com.mrdevv.model.Rol;

public record CreateUsuarioDTO(
        String nombres,
        String apellidos,
        String email,
        String password
) {
}
