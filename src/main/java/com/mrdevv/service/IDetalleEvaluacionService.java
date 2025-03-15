package com.mrdevv.service;

import com.mrdevv.payload.dto.detalleEvaluacion.CreateDetailEvaluationDTO;
import com.mrdevv.payload.dto.detalleEvaluacion.ResponseDetalleEvaluacionDTO;

public interface IDetalleEvaluacionService {

    public ResponseDetalleEvaluacionDTO getDetalleEvaluacion(Long evaluacionId);

    public void saveDetalleEvaluacion(CreateDetailEvaluationDTO detailEvaluation, Long evaluacionId);

}
