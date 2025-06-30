package com.mrdevv.service;

import com.mrdevv.model.Evaluacion;
import com.mrdevv.payload.dto.ResponseWithPageable;
import com.mrdevv.payload.dto.evaluacion.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEvaluacionService {

    List<Evaluacion> getEvaluaciones();

    ResponseWithPageable getEvaluacionesByUser(Long id, Integer page, Integer size);

    ResponseEvaluacionesByUserDTO getLastestEvaluacionesByUser(Long id, Integer size);

    ResponseWithPageable getLastWeekEvaluationsByUser(Long id, Integer page, Integer size);

    ResponseWithPageable getLastMonthEvaluationsByUser(Long id, Integer page, Integer size);

    ResponseEvaluacionSimpleDTO createEvaluacion(CreateEvaluationDTO evaluationDTO);

    void updateResultadoEspecialista(Long id, UpdateResultadoEspecialistaDTO resultadoEspecialistaDTO);

    ResponseTasaAciertoDTO obtenerTasaAcierto();

    ResponseTiempoPromedioDTO obtenerTiempoPromedio();
}
