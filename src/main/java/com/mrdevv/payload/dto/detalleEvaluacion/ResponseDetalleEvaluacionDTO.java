package com.mrdevv.payload.dto.detalleEvaluacion;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
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
    LocalDateTime fecha,
    @JsonProperty("tiempo_prediccion_inicio")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    LocalDateTime tiempoPrediccionInicio,
    @JsonProperty("tiempo_prediccion_fin")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    LocalDateTime tiempoPrediccionFin,
    @JsonProperty("tiempo_prediccion")
    Integer tiempoPrediccion,
    String resultado,
    @JsonProperty("resultado_especialista")
    String resultadoEspecialista,
    List<ResponsePreguntaRespuestaSimpleDTO> listPreguntaRespuesta
) {
}

