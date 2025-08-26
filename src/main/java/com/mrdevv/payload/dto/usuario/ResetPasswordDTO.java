package com.mrdevv.payload.dto.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResetPasswordDTO(
        String token,
        @JsonProperty("new_password")
        String newPassword
) {
}
