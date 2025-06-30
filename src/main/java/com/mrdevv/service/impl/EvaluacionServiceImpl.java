package com.mrdevv.service.impl;

import com.mrdevv.model.Evaluacion;
import com.mrdevv.payload.dto.ResponseWithPageable;
import com.mrdevv.payload.dto.evaluacion.*;
import com.mrdevv.payload.mapper.EvaluacionMapper;
import com.mrdevv.repository.EvaluacionRepository;
import com.mrdevv.service.IDetalleEvaluacionService;
import com.mrdevv.service.IEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public ResponseWithPageable getEvaluacionesByUser(Long id, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Evaluacion> evaluaciones = evaluacionRepository.findAllByUsuarioIdOrderByFechaDesc(id, pageable);
        return EvaluacionMapper.toEvaluacionByUserDTO(evaluaciones);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseEvaluacionesByUserDTO getLastestEvaluacionesByUser(Long id, Integer size) {
        List<Evaluacion> evaluaciones = evaluacionRepository.findLatestByUsuarioIdOrderByFechaDesc(id, size);
        return (ResponseEvaluacionesByUserDTO) EvaluacionMapper.toEvaluacionByUserDTO( evaluaciones);
    }


    @Transactional(readOnly = true)
    @Override
    public ResponseWithPageable getLastWeekEvaluationsByUser(Long id, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Evaluacion> evaluaciones = evaluacionRepository.findLastWeekEvaluationsByUser(id, pageable);
        return EvaluacionMapper.toEvaluacionByUserDTO(evaluaciones);
    }

    @Override
    public ResponseWithPageable getLastMonthEvaluationsByUser(Long id, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Evaluacion> evaluaciones = evaluacionRepository.findLastMonthEvaluationByUser(id, pageable);
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

    @Transactional
    @Override
    public void updateResultadoEspecialista(Long id, UpdateResultadoEspecialistaDTO resultadoEspecialistaDTO) {
        evaluacionRepository.updateResultadoEspecialista(id, resultadoEspecialistaDTO.resultadoEspecialista());
    }

    @Override
    public ResponseTasaAciertoDTO obtenerTasaAcierto() {
        Object datosTasaAcierto = evaluacionRepository.obtenerTasaAciertos();
        return EvaluacionMapper.toResponseTasaAciertoDTO(datosTasaAcierto);
    }

    @Override
    public ResponseTiempoPromedioDTO obtenerTiempoPromedio() {
        Object datosTiempoPromedio = evaluacionRepository.obtenerTiempoPromedio();
        return EvaluacionMapper.toResponseTiempoPromedio(datosTiempoPromedio);
    }
}
