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
        return ResponseHandler.get(TipoResponse.GET, "lista de evaluaciones por usuario", evaluacionesByUser);
    }

}
