package com.mrdevv.service.impl;

import com.mrdevv.model.CuestionarioConocimientos;
import com.mrdevv.payload.dto.cuestionarioConocimientos.CreateCuestionarioConocimientos;
import com.mrdevv.payload.dto.cuestionarioConocimientos.ResponseCuestionarioConocimientosDTO;
import com.mrdevv.payload.mapper.CuestionarioConocimientosMapper;
import com.mrdevv.payload.mapper.RespuestaCuestionarioConocimientosMapper;
import com.mrdevv.repository.CuestionarioConocimientosRepository;
import com.mrdevv.service.ICuestionarioConocimientosService;
import com.mrdevv.service.IRespuestaCuestionarioConocimientosService;
import com.mrdevv.service.IUsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CuestionarioConocimientosServiceImpl implements ICuestionarioConocimientosService {

    private CuestionarioConocimientosRepository cuestionarioConocimientosRepository;

    private IRespuestaCuestionarioConocimientosService respuestaCuestionarioConocimientosService;
    private IUsuarioService usuarioService;

    public CuestionarioConocimientosServiceImpl(
            CuestionarioConocimientosRepository cuestionarioConocimientosRepository,
            IRespuestaCuestionarioConocimientosService respuestaCuestionarioConocimientosService,
            IUsuarioService usuarioService
    ) {
        this.cuestionarioConocimientosRepository = cuestionarioConocimientosRepository;
        this.respuestaCuestionarioConocimientosService = respuestaCuestionarioConocimientosService;
        this.usuarioService = usuarioService;
    }

    @Override
    public List<ResponseCuestionarioConocimientosDTO> getCuestionariosConocimientos() {
        List<CuestionarioConocimientos> cuestionarioConocimientosList = cuestionarioConocimientosRepository.findAll();
        return CuestionarioConocimientosMapper.toListResponseCuestionarioConocimientosDTO(cuestionarioConocimientosList);
    }

    @Transactional
    @Override
    public ResponseCuestionarioConocimientosDTO createCuestionarioConocimientos(CreateCuestionarioConocimientos cuestionarioConocimientos) {
        Integer puntajeTotal = CuestionarioConocimientos.calcularPuntajeTotal(
                RespuestaCuestionarioConocimientosMapper.toListPreguntaCuestionarioConocimientosEntity(cuestionarioConocimientos.respuestas())
        );

//        Guarda los datos del cuestionario (usuario, puntaja total)
        CuestionarioConocimientos cuestionarioConocimientosSave = cuestionarioConocimientosRepository.save(CuestionarioConocimientosMapper.toCuestionarioConocimientosEntity(cuestionarioConocimientos, puntajeTotal));

//        Guarda los datos de las respuestas del cuestionario
        cuestionarioConocimientos.respuestas().forEach(respuesta -> {
                    respuestaCuestionarioConocimientosService.createRespuestaCuestionarioConocimientos(respuesta, cuestionarioConocimientosSave.getId());
                }
        );

        usuarioService.updateEstadoCuestionarioCompletado(cuestionarioConocimientos.usuarioId());

        return CuestionarioConocimientosMapper.toResponseCuestionarioConocimientosDTO(cuestionarioConocimientosSave);
    }
}
