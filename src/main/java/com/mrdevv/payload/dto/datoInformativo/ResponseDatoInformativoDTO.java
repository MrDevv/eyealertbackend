package com.mrdevv.payload.dto.datoInformativo;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseDatoInformativoDTO(
        @JsonProperty("id")
        Long datoInformativoId,
        String titulo,
        String descripcion,
        String fuente,
        @JsonProperty("fuente_multimedia")
        String fuenteMultimedia
) {
}
