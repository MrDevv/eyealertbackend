package com.mrdevv.payload.mapper;

import com.mrdevv.payload.dto.detalleEvaluacion.ResponseDetalleEvaluacionDTO;
import com.mrdevv.payload.dto.detalleEvaluacion.ResponsePreguntaRespuestaSimpleDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DetalleEvaluacionMapper {

    public static ResponseDetalleEvaluacionDTO toDetalleEvaluacionDTO(List<Object[]> evaluaciones) {

        List<ResponsePreguntaRespuestaSimpleDTO> listPreguntasRespuestas = new ArrayList<>();

        if (evaluaciones.isEmpty()) {
            return null;
        }

        Long id = ((Number) evaluaciones.get(0)[0]).longValue();
        Long evaluacionId = ((Number) evaluaciones.get(0)[1]).longValue();
        Date fecha = (Date) evaluaciones.get(0)[2];
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

}
