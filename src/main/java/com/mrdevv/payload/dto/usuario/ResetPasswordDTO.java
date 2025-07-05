package com.mrdevv.payload.dto.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResetPasswordDTO(
        @JsonProperty("new-password")
        String newPassword
) {
}
