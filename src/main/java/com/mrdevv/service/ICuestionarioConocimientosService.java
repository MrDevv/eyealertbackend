package com.mrdevv.service;

import com.mrdevv.payload.dto.cuestionarioConocimientos.CreateCuestionarioConocimientos;
import com.mrdevv.payload.dto.cuestionarioConocimientos.ResponseCuestionarioConocimientosDTO;
import com.mrdevv.payload.dto.cuestionarioConocimientos.ResponseIndiceConocimientoDTO;

import java.util.List;

public interface ICuestionarioConocimientosService {

    public List<ResponseCuestionarioConocimientosDTO> getCuestionariosConocimientos();

    public ResponseCuestionarioConocimientosDTO createCuestionarioConocimientos(CreateCuestionarioConocimientos cuestionarioConocimientos);

    public ResponseIndiceConocimientoDTO obtenerIndiceConocimiento();
}
