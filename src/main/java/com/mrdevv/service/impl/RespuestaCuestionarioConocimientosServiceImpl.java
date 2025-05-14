package com.mrdevv.service.impl;

import com.mrdevv.payload.dto.cuestionarioConocimientos.CreateRespuestaCuestionarioConocimientos;
import com.mrdevv.payload.mapper.RespuestaCuestionarioConocimientosMapper;
import com.mrdevv.repository.RespuestaCuestionarioConocimientosRepository;
import com.mrdevv.service.IRespuestaCuestionarioConocimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RespuestaCuestionarioConocimientosServiceImpl implements IRespuestaCuestionarioConocimientosService {


    private RespuestaCuestionarioConocimientosRepository respuestaCuestionarioConocimientosRepository;

    @Autowired
    public RespuestaCuestionarioConocimientosServiceImpl(RespuestaCuestionarioConocimientosRepository respuestaCuestionarioConocimientosRepository) {
        this.respuestaCuestionarioConocimientosRepository = respuestaCuestionarioConocimientosRepository;
    }

    @Transactional
    @Override
    public void createRespuestaCuestionarioConocimientos(CreateRespuestaCuestionarioConocimientos respuestaCuestionarioConocimientos, Long cuestionarioConocimientoId) {
        respuestaCuestionarioConocimientosRepository.save(
                RespuestaCuestionarioConocimientosMapper.toPreguntaCuestionarioConocimientosEntity(respuestaCuestionarioConocimientos, cuestionarioConocimientoId)
        );
    }
}
