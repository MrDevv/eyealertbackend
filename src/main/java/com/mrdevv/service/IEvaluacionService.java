package com.mrdevv.service;

import com.mrdevv.model.Evaluacion;
import com.mrdevv.payload.dto.evaluacion.ResponseEvaluacionesByUserDTO;

import java.util.List;

public interface IEvaluacionService {


    List<Evaluacion> getEvaluaciones();


    ResponseEvaluacionesByUserDTO getEvaluacionesByUser(Long id);

    ResponseEvaluacionesByUserDTO getLastEvaluacionesByUser(Long id);
}
