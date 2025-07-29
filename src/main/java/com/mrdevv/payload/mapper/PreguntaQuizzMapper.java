package com.mrdevv.payload.mapper;

import com.mrdevv.model.PreguntaQuizz;
import com.mrdevv.model.RespuestaQuizz;
import com.mrdevv.payload.dto.quizz.ResponsePreguntaQuizzDTO;
import com.mrdevv.payload.dto.quizz.ResponseRespuestaQuizz;

import java.util.List;

public class PreguntaQuizzMapper {

    public static List<ResponsePreguntaQuizzDTO> toPreguntaQuizzListDTO(List<PreguntaQuizz> preguntaQuizzes){
        return preguntaQuizzes.stream().map(preguntaQuizz -> {
            return new ResponsePreguntaQuizzDTO(
                    preguntaQuizz.getId(),
                    preguntaQuizz.getPregunta(),
                    preguntaQuizz.getCategoria(),
                    RespuestaQuizzMapper.toRespuestaQuizzListDTO(preguntaQuizz.getRespuestaQuizzes())
            );
        }).toList();
    }


}
