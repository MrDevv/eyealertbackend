package com.mrdevv.payload.dto.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record UpdatePasswordDTO(
        @NotNull(message = "El campo [contraseña_actual] es obligatorio")
        @JsonProperty(value = "contraseña_actual")
        String passwordCurrent,
        @NotNull(message = "El campo [nueva_contraseña] es obligatorio")
        @JsonProperty(value = "nueva_contraseña")
        String newPassword,
        @NotNull(message = "El campo [contraseña_repetida] es obligatorio")
        @JsonProperty(value = "contraseña_repetida")
        String repeatedPassword
) {
}
