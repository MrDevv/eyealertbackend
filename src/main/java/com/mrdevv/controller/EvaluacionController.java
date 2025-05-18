package com.mrdevv.controller;

import com.mrdevv.model.Evaluacion;
import com.mrdevv.payload.ResponseHandler;
import com.mrdevv.payload.dto.evaluacion.*;
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

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateResultadoEspecialista(@PathVariable(name = "id") Long evaluacionId, @Valid @RequestBody UpdateResultadoEspecialistaDTO resultadoEspecialistaDTO){
        evaluacionService.updateResultadoEspecialista(evaluacionId, resultadoEspecialistaDTO);
        return ResponseHandler.get(TipoResponse.PATCH, "se actualizó correctamente el resultado del especialista", null);
    }

    @GetMapping("/tasa-acierto")
    public ResponseEntity<Object> obtenerTasaAcierto(){
        ResponseTasaAciertoDTO tasaAciertoDTO = evaluacionService.obtenerTasaAcierto();
        return ResponseHandler.get(TipoResponse.GET, "se obtuvo correctamente la tasa de acierto", tasaAciertoDTO);
    }

    @GetMapping("/tiempo-promedio-prediccion")
    public ResponseEntity<Object> obtenerTiempoPromedioPrediccion(){
        ResponseTiempoPromedioDTO tiempoPromedioDTO = evaluacionService.obtenerTiempoPromedio();
        return ResponseHandler.get(TipoResponse.GET, "se obtuvo correctamente el tiempo promedio de predicción", tiempoPromedioDTO);
    }

}
