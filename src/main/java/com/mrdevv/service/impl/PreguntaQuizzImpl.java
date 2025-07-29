package com.mrdevv.service.impl;

import com.mrdevv.model.PreguntaQuizz;
import com.mrdevv.payload.dto.quizz.ResponsePreguntaQuizzDTO;
import com.mrdevv.payload.mapper.PreguntaQuizzMapper;
import com.mrdevv.repository.PreguntaQuizzRepository;
import com.mrdevv.service.IPreguntaQuizz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaQuizzImpl implements IPreguntaQuizz {

    private PreguntaQuizzRepository preguntaQuizzRepository;

    @Autowired
    public PreguntaQuizzImpl(PreguntaQuizzRepository preguntaQuizzRepository){
        this.preguntaQuizzRepository = preguntaQuizzRepository;
    }

    @Override
    public List<ResponsePreguntaQuizzDTO> obtenerPreguntasQuizz(Integer limit) {
        List<PreguntaQuizz> preguntaQuizzList = preguntaQuizzRepository.findAllPreguntas(limit);
        return PreguntaQuizzMapper.toPreguntaQuizzListDTO(preguntaQuizzList);
    }
}
