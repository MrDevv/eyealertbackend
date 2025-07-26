package com.mrdevv.payload.mapper;

import com.mrdevv.model.Quizz;
import com.mrdevv.payload.dto.PageableData;
import com.mrdevv.payload.dto.ResponseWithPageable;
import com.mrdevv.payload.dto.quizz.ResponsePuntajeUsuario;
import com.mrdevv.payload.dto.quizz.ResponseQuizz;
import org.springframework.data.domain.Page;

import java.util.List;

public class QuizzMapper {

    public static ResponseWithPageable toQuizzDTO(Page<Quizz> quizzes){

        PageableData pageableData = PageableMapper.toPageableData(quizzes);

        List<ResponseQuizz> responseQuizzes = quizzes.stream().map(quizz -> {
            return new ResponseQuizz(
                    quizz.getQuizzId(),
                    quizz.getPuntaje(),
                    quizz.getFecha(),
                    UsuarioMapper.toUsuarioSimpleDTO(quizz.getUsuario())
            );
        }).toList();

        return new ResponseWithPageable(responseQuizzes, pageableData);
    }

    public static ResponsePuntajeUsuario toPuntajeUsuarioDTO(Object puntajeUsuario){
        Object[] puntaje = (Object[]) puntajeUsuario;

        if (puntaje[0] == null){
            return null;
        }

        Integer puntajeMasAlto = ((Number) puntaje[0]).intValue();
        Integer ultimoPuntaje = ((Number) puntaje[1]).intValue();

        return new ResponsePuntajeUsuario(puntajeMasAlto, ultimoPuntaje);
    }
}
