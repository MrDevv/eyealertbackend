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
        LocalDateTime tiempoPrediccionInicio = ((Timestamp) evaluaciones.get(0)[3]).toLocalDateTime();
        LocalDateTime tiempoPrediccionFin = ((Timestamp) evaluaciones.get(0)[4]).toLocalDateTime();
        Integer tiempoPrediccion = ((Number) evaluaciones.get(0)[5]).intValue();
        String resultado = (Boolean) evaluaciones.get(0)[6] ? "alto" : "bajo";
        String resultadoEspecialista;
        String nombres = evaluaciones.get(0)[8].toString();
        String apellidos = evaluaciones.get(0)[9].toString();

        if (evaluaciones.get(0)[7]!=null){
            resultadoEspecialista = (Boolean) evaluaciones.get(0)[7] ? "acertado" : "no acertado";
        }else{
            resultadoEspecialista = "pendiente";
        }

        listPreguntasRespuestas = evaluaciones.stream().map(evaluacion -> {
                    String pregunta = evaluacion[10].toString();
                    String respuesta;

                    if (evaluacion[11] != null) {
                        respuesta = evaluacion[11].toString();
                    }else{
                        respuesta = evaluacion[12].toString();
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
                tiempoPrediccionInicio,
                tiempoPrediccionFin,
                tiempoPrediccion,
                resultado,
                resultadoEspecialista,
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
