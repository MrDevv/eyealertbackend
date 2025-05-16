package com.mrdevv.payload.dto.cuestionarioConocimientos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseIndiceConocimientoDTO(
    @JsonProperty("puntaje_total_obtenido")
    Integer puntajeTotalObtenido,
    @JsonProperty("numero_participantes")
    Integer numeroParticipantes,
    @JsonProperty("puntaje_total_posible")
    Integer puntajeTotalPosible,
    @JsonProperty("indice_conocimiento")
    Double indiceConocimiento
) {
}
