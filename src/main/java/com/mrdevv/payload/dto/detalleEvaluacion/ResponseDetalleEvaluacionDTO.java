package com.mrdevv.payload.dto.detalleEvaluacion;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public record ResponseDetalleEvaluacionDTO(
    @JsonProperty("detalle_evaluacion_id")
    Long detalleEvaluacionId,
    @JsonProperty("evaluacion_id")
    Long evaluacionId,
    String nombres,
    String apellidos,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    Date fecha,
    @JsonProperty("tiempo_prediccion")
    Integer tiempoPrediccion,
    String resultado,
    List<ResponsePreguntaRespuestaSimpleDTO> listPreguntaRespuesta
) {
}

