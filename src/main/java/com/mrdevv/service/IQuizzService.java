package com.mrdevv.service;

import com.mrdevv.payload.dto.ResponseWithPageable;
import com.mrdevv.payload.dto.quizz.CreateQuizzDTO;
import com.mrdevv.payload.dto.quizz.ResponsePuntajeUsuario;
import com.mrdevv.payload.dto.quizz.ResponseQuizzDTO;
import com.mrdevv.payload.dto.quizz.ResponseRankingDTO;
import org.springframework.data.domain.Pageable;

public interface IQuizzService {

    ResponseWithPageable listarQuizzes(Pageable pageable);

    ResponsePuntajeUsuario obtenerPuntajeUsuario(Long usuarioId);

    ResponseRankingDTO obtenerRanking();

    ResponseQuizzDTO crearQuizz(CreateQuizzDTO quizzDTO);
}
