package com.mrdevv.service;

import com.mrdevv.model.Pregunta;
import com.mrdevv.payload.dto.pregunta.ResponsePreguntasDTO;

import java.util.List;

public interface IPreguntaService {

    List<ResponsePreguntasDTO> getPreguntas();

}
