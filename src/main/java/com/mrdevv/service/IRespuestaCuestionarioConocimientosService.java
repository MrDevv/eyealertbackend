package com.mrdevv.service;

import com.mrdevv.payload.dto.cuestionarioConocimientos.CreateRespuestaCuestionarioConocimientos;

public interface IRespuestaCuestionarioConocimientosService {

    public void createRespuestaCuestionarioConocimientos(CreateRespuestaCuestionarioConocimientos preguntaCuestionarioConocimientos, Long cuestionarioConocimientosId);
}
