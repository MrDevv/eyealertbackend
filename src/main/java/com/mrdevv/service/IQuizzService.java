package com.mrdevv.service;

import com.mrdevv.model.Quizz;
import com.mrdevv.payload.dto.ResponseWithPageable;
import com.mrdevv.payload.dto.quizz.ResponsePuntajeUsuario;
import com.mrdevv.payload.dto.quizz.ResponseRankingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuizzService {

    ResponseWithPageable listarQuizzes(Pageable pageable);

    ResponsePuntajeUsuario obtenerPuntajeUsuario(Long usuarioId);

    ResponseRankingDTO obtenerRanking();
}
