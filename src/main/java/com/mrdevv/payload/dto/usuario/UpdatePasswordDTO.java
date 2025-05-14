package com.mrdevv.payload.dto.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdatePasswordDTO(
        @JsonProperty("new-password")
        String newPassword
) {
}
