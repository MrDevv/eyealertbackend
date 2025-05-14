package com.mrdevv.service;

import com.mrdevv.payload.dto.cuestionarioConocimientos.CreateCuestionarioConocimientos;
import com.mrdevv.payload.dto.cuestionarioConocimientos.ResponseCuestionarioConocimientosDTO;

import java.util.List;

public interface ICuestionarioConocimientosService {

    public List<ResponseCuestionarioConocimientosDTO> getCuestionariosConocimientos();

    public ResponseCuestionarioConocimientosDTO createCuestionarioConocimientos(CreateCuestionarioConocimientos cuestionarioConocimientos);
}
