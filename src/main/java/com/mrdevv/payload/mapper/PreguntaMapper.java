package com.mrdevv.payload.mapper;

import com.mrdevv.payload.dto.pregunta.ResponsePreguntasDTO;
import com.mrdevv.payload.dto.respuesta.ResponseRespuestasDTO;

import java.util.ArrayList;
import java.util.List;

public class PreguntaMapper {

    public static List<ResponsePreguntasDTO> toPreguntasDTO(List<Object[]> preguntas){

        List<ResponsePreguntasDTO> responsePreguntasDTOS = new ArrayList<>();

        for (Object[] result : preguntas) {
            long preguntaId = ((Number) result[0]).longValue();
            String pregunta = (String) result[1];
            String respuestas = (String) result[2];

            List<ResponseRespuestasDTO> respuestasDTO = new ArrayList<>();

            if (respuestas != null) {
                String[] respuestasPregunta = respuestas.split(",");

                for (String respuesta : respuestasPregunta) {
                    respuestasDTO.add(new ResponseRespuestasDTO(respuesta));
                }
            }

            ResponsePreguntasDTO responsePreguntasDTO = new ResponsePreguntasDTO(
                    preguntaId,
                    pregunta,
                    respuestasDTO
            );

            responsePreguntasDTOS.add(responsePreguntasDTO);
        }

        return responsePreguntasDTOS;
    }
}
