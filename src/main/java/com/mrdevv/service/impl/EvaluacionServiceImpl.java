package com.mrdevv.service.impl;

import com.mrdevv.model.Evaluacion;
import com.mrdevv.payload.dto.evaluacion.ResponseEvaluacionesByUserDTO;
import com.mrdevv.payload.mapper.EvaluacionMapper;
import com.mrdevv.repository.EvaluacionRepository;
import com.mrdevv.service.IEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluacionServiceImpl implements IEvaluacionService {

    private EvaluacionRepository evaluacionRepository;

    @Autowired
    EvaluacionServiceImpl(EvaluacionRepository evaluacionRepository){
        this.evaluacionRepository = evaluacionRepository;
    }

    @Override
    public List<Evaluacion> getEvaluaciones() {
        return evaluacionRepository.findAll();
    }

    @Override
    public ResponseEvaluacionesByUserDTO getEvaluacionesByUser(Long id) {
        List<Evaluacion> evaluacions = evaluacionRepository.findAllByUsuarioId(id);
        return EvaluacionMapper.toEvaluacionByUserDTO(evaluacions);
    }

    @Override
    public ResponseEvaluacionesByUserDTO getLastEvaluacionesByUser(Long id) {
        List<Evaluacion> evaluacions = evaluacionRepository.findTop3ByUsuarioIdOrderByFechaDesc(id);
        return EvaluacionMapper.toEvaluacionByUserDTO(evaluacions);
    }
}
