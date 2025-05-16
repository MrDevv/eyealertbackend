package com.mrdevv.payload.dto.evaluacion;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseTasaAciertoDTO(
        @JsonProperty("total_evaluaciones")
        Integer totalEvaluaciones,
        @JsonProperty("evaluaciones_acertadas")
        Integer evaluacionesAcertadas,
        @JsonProperty("evaluaciones_no_acertadas")
        Integer evaluacionesNoAcertadas,
        @JsonProperty("evaluaciones_pendientes_revision")
        Integer evaluacionesPendienteRevision,
        @JsonProperty("tasa_acierto")
        Double tasaAcieto
) {
}
