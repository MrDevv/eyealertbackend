package com.mrdevv.service;

import com.mrdevv.payload.dto.detalleEvaluacion.CreateDetailEvaluation;
import com.mrdevv.payload.dto.detalleEvaluacion.ResponseDetalleEvaluacionDTO;

public interface IDetalleEvaluacionService {

    public ResponseDetalleEvaluacionDTO getDetalleEvaluacion(Long evaluacionId);

    public void saveDetalleEvaluacion(CreateDetailEvaluation detailEvaluation, Long evaluacionId);

}
