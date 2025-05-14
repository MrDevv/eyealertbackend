package com.mrdevv.payload.mapper;

import com.mrdevv.model.CuestionarioConocimientos;
import com.mrdevv.model.RespuestaCuestionarioConocimientos;
import com.mrdevv.payload.dto.cuestionarioConocimientos.CreateRespuestaCuestionarioConocimientos;

import java.util.List;

public class RespuestaCuestionarioConocimientosMapper {

    public static RespuestaCuestionarioConocimientos toPreguntaCuestionarioConocimientosEntity(CreateRespuestaCuestionarioConocimientos preguntaCuestionarioConocimientos, Long cuestionarioConocimientosId){
        return RespuestaCuestionarioConocimientos.builder()
                .cuestionarioConocimientos(CuestionarioConocimientos.builder().id(cuestionarioConocimientosId).build())
                .pregunta(preguntaCuestionarioConocimientos.pregunta())
                .respuesta(preguntaCuestionarioConocimientos.respuesta())
                .puntajePregunta(preguntaCuestionarioConocimientos.puntajePregunta())
                .build();
    }

    public static List<RespuestaCuestionarioConocimientos> toListPreguntaCuestionarioConocimientosEntity(List<CreateRespuestaCuestionarioConocimientos> listPreguntasCuestionario){
        return listPreguntasCuestionario.stream().map(preguntaCuestionarioConocimientos ->{
            return RespuestaCuestionarioConocimientos.builder()
                    .pregunta(preguntaCuestionarioConocimientos.pregunta())
                    .respuesta(preguntaCuestionarioConocimientos.respuesta())
                    .puntajePregunta(preguntaCuestionarioConocimientos.puntajePregunta())
                    .build();
        }).toList();

    }
}
