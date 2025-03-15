package com.mrdevv.service;

import com.mrdevv.model.Evaluacion;
import com.mrdevv.payload.dto.evaluacion.CreateEvaluationDTO;
import com.mrdevv.payload.dto.evaluacion.ResponseEvaluacionSimpleDTO;
import com.mrdevv.payload.dto.evaluacion.ResponseEvaluacionesByUserDTO;

import java.util.List;

public interface IEvaluacionService {


    List<Evaluacion> getEvaluaciones();


    ResponseEvaluacionesByUserDTO getEvaluacionesByUser(Long id);

    ResponseEvaluacionesByUserDTO getLastEvaluacionesByUser(Long id);

    ResponseEvaluacionesByUserDTO getLastWeekEvaluationsByUser(Long id);

    ResponseEvaluacionSimpleDTO createEvaluacion(CreateEvaluationDTO evaluationDTO);
}
