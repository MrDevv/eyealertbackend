package com.mrdevv.service.impl;

import com.mrdevv.model.Evaluacion;
import com.mrdevv.payload.dto.evaluacion.CreateEvaluationDTO;
import com.mrdevv.payload.dto.evaluacion.ResponseEvaluacionSimpleDTO;
import com.mrdevv.payload.dto.evaluacion.ResponseEvaluacionesByUserDTO;
import com.mrdevv.payload.mapper.EvaluacionMapper;
import com.mrdevv.repository.EvaluacionRepository;
import com.mrdevv.service.IDetalleEvaluacionService;
import com.mrdevv.service.IEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EvaluacionServiceImpl implements IEvaluacionService {

    private EvaluacionRepository evaluacionRepository;
    private IDetalleEvaluacionService detalleEvaluacionService;

    @Autowired
    EvaluacionServiceImpl(EvaluacionRepository evaluacionRepository, IDetalleEvaluacionService detalleEvaluacionService){
        this.evaluacionRepository = evaluacionRepository;
        this.detalleEvaluacionService = detalleEvaluacionService;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Evaluacion> getEvaluaciones() {
        return evaluacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseEvaluacionesByUserDTO getEvaluacionesByUser(Long id) {
        List<Evaluacion> evaluaciones = evaluacionRepository.findAllByUsuarioIdOrderByFechaDesc(id);
        return EvaluacionMapper.toEvaluacionByUserDTO(evaluaciones);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseEvaluacionesByUserDTO getLastEvaluacionesByUser(Long id) {
        List<Evaluacion> evaluaciones = evaluacionRepository.findTop3ByUsuarioIdOrderByFechaDesc(id);
        return EvaluacionMapper.toEvaluacionByUserDTO(evaluaciones);
    }


    @Transactional(readOnly = true)
    @Override
    public ResponseEvaluacionesByUserDTO getLastWeekEvaluationsByUser(Long id) {
        List<Evaluacion> evaluaciones = evaluacionRepository.findLastWeekEvaluationsByUser(id);
        return EvaluacionMapper.toEvaluacionByUserDTO(evaluaciones);
    }

    @Override
    public ResponseEvaluacionesByUserDTO getLastMonthEvaluationsByUser(Long id) {
        List<Evaluacion> evaluaciones = evaluacionRepository.findLastMonthEvaluationByUser(id);
        return EvaluacionMapper.toEvaluacionByUserDTO(evaluaciones);
    }

    @Transactional
    @Override
    public ResponseEvaluacionSimpleDTO createEvaluacion(CreateEvaluationDTO evaluationDTO) {
        Evaluacion evaluacion = evaluacionRepository.save(EvaluacionMapper.toEvaluacionEntity(evaluationDTO));

        evaluationDTO.detallesEvaluacion().forEach(detalleEvaluacion ->{
            detalleEvaluacionService.saveDetalleEvaluacion(detalleEvaluacion, evaluacion.getId());
        });

        return EvaluacionMapper.toEvaluacionDTO(evaluacion);
    }
}
