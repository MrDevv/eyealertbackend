package com.mrdevv.controller;

import com.mrdevv.model.Evaluacion;
import com.mrdevv.payload.ResponseHandler;
import com.mrdevv.payload.dto.evaluacion.ResponseEvaluacionesByUserDTO;
import com.mrdevv.service.IEvaluacionService;
import com.mrdevv.utils.TipoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {

    private IEvaluacionService evaluacionService;

    @Autowired
    public EvaluacionController(IEvaluacionService evaluacionService){
        this.evaluacionService = evaluacionService;
    }

    @GetMapping
    public ResponseEntity<Object> getEvaluaciones(){
        List<Evaluacion> evaluaciones = evaluacionService.getEvaluaciones();
        return ResponseHandler.get(TipoResponse.GET, "lista de evaluaciones", evaluaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEvaluacionesByUser(@PathVariable Long id){
        ResponseEvaluacionesByUserDTO evaluacionesByUser = evaluacionService.getEvaluacionesByUser(id);
        return ResponseHandler.get(TipoResponse.GET, "lista de evaluaciones del usuario", evaluacionesByUser);
    }

    @GetMapping("/{id}/last")
    public ResponseEntity<Object> getLastEvaluacionesByUser(@PathVariable Long id){
        ResponseEvaluacionesByUserDTO evaluacionesByUser = evaluacionService.getLastEvaluacionesByUser(id);
        return ResponseHandler.get(TipoResponse.GET, "lista de ultimas 3 evaluacion del usuario", evaluacionesByUser);
    }

    @GetMapping("/{id}/lastWeek")
    public ResponseEntity<Object> getLastWeekEvaluationsByUser(@PathVariable Long id){
        ResponseEvaluacionesByUserDTO lastWeekEvaluationsByUser = evaluacionService.getLastWeekEvaluationsByUser(id);
        return ResponseHandler.get(TipoResponse.GET, "lista de evaluaciones de la última semana del usuario", lastWeekEvaluationsByUser);
    }

}
