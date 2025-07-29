package com.mrdevv.service;

import com.mrdevv.model.PreguntaQuizz;
import com.mrdevv.payload.dto.quizz.ResponsePreguntaQuizzDTO;

import java.util.List;

public interface IPreguntaQuizz {

    List<ResponsePreguntaQuizzDTO> obtenerPreguntasQuizz(Integer limit);
}
