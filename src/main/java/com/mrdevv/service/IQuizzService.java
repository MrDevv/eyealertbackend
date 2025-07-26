package com.mrdevv.service;

import com.mrdevv.model.Quizz;
import com.mrdevv.payload.dto.ResponseWithPageable;
import com.mrdevv.payload.dto.quizz.ResponsePuntajeUsuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuizzService {

    ResponseWithPageable listarQuizzes(Pageable pageable);

    ResponsePuntajeUsuario obtenerPuntajeUsuario(Long usuarioId);
}
