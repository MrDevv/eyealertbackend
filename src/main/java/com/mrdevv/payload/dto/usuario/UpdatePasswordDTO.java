package com.mrdevv.payload.dto.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdatePasswordDTO(
        @JsonProperty(value = "contraseña_actual")
        String passwordCurrent,
        @JsonProperty(value = "nueva_contraseña")
        String newPassword,
        @JsonProperty(value = "contraseña_repetida")
        String repeatedPassword
) {
}
