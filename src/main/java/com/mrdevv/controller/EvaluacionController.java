package com.mrdevv.controller;

import com.mrdevv.model.Evaluacion;
import com.mrdevv.payload.ResponseHandler;
import com.mrdevv.payload.dto.evaluacion.CreateEvaluationDTO;
import com.mrdevv.payload.dto.evaluacion.ResponseEvaluacionSimpleDTO;
import com.mrdevv.service.IEvaluacionService;
import com.mrdevv.utils.TipoResponse;
import jakarta.validation.Valid;
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

    @PostMapping
    public ResponseEntity<Object> crearEvaluacion(@Valid @RequestBody CreateEvaluationDTO evaluationDTO){
        ResponseEvaluacionSimpleDTO evaluacionSimpleDTO = evaluacionService.createEvaluacion(evaluationDTO);
        return ResponseHandler.get(TipoResponse.CREATE, "se creo correctamente la evaluación y su detalle", evaluacionSimpleDTO);
    }

}
