package com.mrdevv.payload.dto.usuario;

import jakarta.validation.constraints.NotNull;

public record UpdateUsuarioDTO(
        @NotNull
        String nombres,
        @NotNull
        String apellidos,
        @NotNull
        String email
) {
}
