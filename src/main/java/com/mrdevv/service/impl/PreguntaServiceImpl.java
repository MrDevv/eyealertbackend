package com.mrdevv.service.impl;

import com.mrdevv.model.Pregunta;
import com.mrdevv.payload.dto.pregunta.ResponsePreguntasDTO;
import com.mrdevv.payload.mapper.PreguntaMapper;
import com.mrdevv.repository.PreguntaRepository;
import com.mrdevv.service.IPreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaServiceImpl implements IPreguntaService {

    private PreguntaRepository preguntaRepository;

    @Autowired
    public PreguntaServiceImpl(PreguntaRepository preguntaRepository){
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public List<ResponsePreguntasDTO> getPreguntas() {
        List<Object[]> preguntasResponse = preguntaRepository.getPreguntas();
        return PreguntaMapper.toPreguntasDTO(preguntasResponse);
    }
}
