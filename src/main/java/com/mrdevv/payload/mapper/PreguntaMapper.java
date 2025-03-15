package com.mrdevv.payload.mapper;

import com.mrdevv.model.Pregunta;
import com.mrdevv.payload.dto.pregunta.ResponsePreguntasDTO;
import com.mrdevv.payload.dto.respuesta.ResponseRespuestasDTO;

import java.util.ArrayList;
import java.util.List;

public class PreguntaMapper {

    public static List<ResponsePreguntasDTO> toPreguntasDTO(List<Pregunta> preguntas) {
        List<ResponsePreguntasDTO> responsePreguntasDTOS = new ArrayList<>();

        preguntas.forEach(pregunta -> {
            List<ResponseRespuestasDTO> respuestasDTO = pregunta.getRespuestas().stream().map(respuesta -> {
                        return new ResponseRespuestasDTO(
                                respuesta.getId(),
                                respuesta.getDescripcion()
                        );
                    }
            ).toList();

            responsePreguntasDTOS.add(new ResponsePreguntasDTO(
                    pregunta.getId(),
                    pregunta.getDescripcion(),
                    respuestasDTO
            ));
        });

        return responsePreguntasDTOS;
    }
}
