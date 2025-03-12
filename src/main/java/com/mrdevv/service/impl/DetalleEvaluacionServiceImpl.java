package com.mrdevv.service.impl;

import com.mrdevv.payload.dto.detalleEvaluacion.ResponseDetalleEvaluacionDTO;
import com.mrdevv.payload.mapper.DetalleEvaluacionMapper;
import com.mrdevv.repository.DetalleEvaluacionRepository;
import com.mrdevv.service.IDetalleEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleEvaluacionServiceImpl implements IDetalleEvaluacionService {

    private DetalleEvaluacionRepository detalleEvaluacionRepository;

    @Autowired
    public DetalleEvaluacionServiceImpl(DetalleEvaluacionRepository detalleEvaluacionRepository){
        this.detalleEvaluacionRepository = detalleEvaluacionRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseDetalleEvaluacionDTO getDetalleEvaluacion(Long evaluacionId) {
        List<Object[]> detalleEvaluaciones =  detalleEvaluacionRepository.findDetalleEvaluacion(evaluacionId);
        return DetalleEvaluacionMapper.toDetalleEvaluacionDTO(detalleEvaluaciones);
    }
}
