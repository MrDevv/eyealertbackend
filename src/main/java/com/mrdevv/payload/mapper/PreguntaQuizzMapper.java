package com.mrdevv.payload.mapper;

import com.mrdevv.model.PreguntaQuizz;
import com.mrdevv.model.RespuestaQuizz;
import com.mrdevv.payload.dto.quizz.ResponsePreguntaQuizzDTO;
import com.mrdevv.payload.dto.quizz.ResponseRespuestaQuizz;

import java.util.Collections;
import java.util.List;

public class PreguntaQuizzMapper {

    public static List<ResponsePreguntaQuizzDTO> toPreguntaQuizzListDTO(List<PreguntaQuizz> preguntaQuizzes){
        return preguntaQuizzes.stream().map(preguntaQuizz -> {
            List<ResponseRespuestaQuizz> respuestaQuizzes = RespuestaQuizzMapper.toRespuestaQuizzListDTO(preguntaQuizz.getRespuestaQuizzes());
            Collections.shuffle(respuestaQuizzes);

            return new ResponsePreguntaQuizzDTO(
                    preguntaQuizz.getId(),
                    preguntaQuizz.getPregunta(),
                    preguntaQuizz.getCategoria(),
                    respuestaQuizzes
            );
        }).toList();
    }


}
