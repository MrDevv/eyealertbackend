package com.mrdevv.payload.mapper;

import com.mrdevv.model.RespuestaQuizz;
import com.mrdevv.payload.dto.quizz.ResponseRespuestaQuizz;

import java.util.List;

public class RespuestaQuizzMapper {

    public static List<ResponseRespuestaQuizz> toRespuestaQuizzListDTO(List<RespuestaQuizz> respuestaQuizzList){
        return respuestaQuizzList.stream().map(respuestaQuizz -> {
            return new ResponseRespuestaQuizz(
                    respuestaQuizz.getId(),
                    respuestaQuizz.getRespuesta(),
                    respuestaQuizz.getExplicacion(),
                    respuestaQuizz.getEsCorrecta()
            );
        }).toList();
    }
}
