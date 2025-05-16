package com.mrdevv.service;

import com.mrdevv.model.Evaluacion;
import com.mrdevv.payload.dto.evaluacion.*;

import java.util.List;

public interface IEvaluacionService {


    List<Evaluacion> getEvaluaciones();


    ResponseEvaluacionesByUserDTO getEvaluacionesByUser(Long id);

    ResponseEvaluacionesByUserDTO getLastEvaluacionesByUser(Long id);

    ResponseEvaluacionesByUserDTO getLastWeekEvaluationsByUser(Long id);

    ResponseEvaluacionesByUserDTO getLastMonthEvaluationsByUser(Long id);

    ResponseEvaluacionSimpleDTO createEvaluacion(CreateEvaluationDTO evaluationDTO);

    ResponseTasaAciertoDTO obtenerTasaAcierto();

    ResponseTiempoPromedioDTO obtenerTiempoPromedio();
}
