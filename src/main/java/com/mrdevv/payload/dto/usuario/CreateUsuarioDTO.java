package com.mrdevv.payload.dto.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mrdevv.model.Rol;
import jakarta.validation.constraints.NotNull;

public record CreateUsuarioDTO(
        @NotNull
        String nombres,
        @NotNull
        String apellidos,
        @NotNull
        String email,
        @NotNull
        String password,
        @JsonProperty(value = "password_repetida")
        String passwordRepetida
) {
}
