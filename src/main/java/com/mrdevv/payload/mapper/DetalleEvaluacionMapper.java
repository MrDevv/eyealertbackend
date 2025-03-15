package com.mrdevv.payload.mapper;

import com.mrdevv.model.DetalleEvaluacion;
import com.mrdevv.model.Evaluacion;
import com.mrdevv.model.Pregunta;
import com.mrdevv.model.Respuesta;
import com.mrdevv.payload.dto.detalleEvaluacion.CreateDetailEvaluationDTO;
import com.mrdevv.payload.dto.detalleEvaluacion.ResponseDetalleEvaluacionDTO;
import com.mrdevv.payload.dto.detalleEvaluacion.ResponsePreguntaRespuestaSimpleDTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DetalleEvaluacionMapper {

    public static ResponseDetalleEvaluacionDTO toDetalleEvaluacionDTO(List<Object[]> evaluaciones) {

        List<ResponsePreguntaRespuestaSimpleDTO> listPreguntasRespuestas = new ArrayList<>();

        if (evaluaciones.isEmpty()) {
            return null;
        }

        System.out.println(evaluaciones.get(0)[2]);

        Long id = ((Number) evaluaciones.get(0)[0]).longValue();
        Long evaluacionId = ((Number) evaluaciones.get(0)[1]).longValue();
        LocalDateTime fecha = ((Timestamp) evaluaciones.get(0)[2]).toLocalDateTime();
        Integer tiempoPrediccion = ((Number) evaluaciones.get(0)[3]).intValue();
        String resultado = (Boolean) evaluaciones.get(0)[4] ? "alto" : "bajo";
        String nombres = evaluaciones.get(0)[5].toString();
        String apellidos = evaluaciones.get(0)[6].toString();


        listPreguntasRespuestas = evaluaciones.stream().map(evaluacion -> {
                    String pregunta = evaluacion[7].toString();
                    String respuesta;

                    if (evaluacion[8] != null) {
                        respuesta = evaluacion[8].toString();
                    }else{
                        respuesta = evaluacion[9].toString();
                    }

                    return new ResponsePreguntaRespuestaSimpleDTO(
                            pregunta,
                            respuesta
                    );
                }
        ).toList();


        return new ResponseDetalleEvaluacionDTO(
                id,
                evaluacionId,
                nombres,
                apellidos,
                 fecha,
                tiempoPrediccion,
                resultado,
                listPreguntasRespuestas
        );

    }

    public static DetalleEvaluacion toDetalleEvaluacionEntity(CreateDetailEvaluationDTO detailEvaluation, Long evaluacionId){
        Respuesta respuesta = new Respuesta();

        if (detailEvaluation.respuestaId() != null){
            respuesta.setId(detailEvaluation.respuestaId());
        }else{
            respuesta = null;
        }

        return DetalleEvaluacion.builder()
                .evaluacion(Evaluacion.builder().id(evaluacionId).build())
                .pregunta(Pregunta.builder().id(detailEvaluation.preguntaId()).build())
                .respuesta(respuesta)
                .respuestaTexto(detailEvaluation.respuestaTexto())
                .build();
    }

}
