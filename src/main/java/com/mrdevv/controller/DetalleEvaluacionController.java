package com.mrdevv.controller;


import com.mrdevv.payload.ResponseHandler;
import com.mrdevv.payload.dto.detalleEvaluacion.ResponseDetalleEvaluacionDTO;
import com.mrdevv.service.IDetalleEvaluacionService;
import com.mrdevv.utils.TipoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detalleEvaluacion")
public class DetalleEvaluacionController {

    private IDetalleEvaluacionService detalleEvaluacionService;

    @Autowired
    public DetalleEvaluacionController(IDetalleEvaluacionService detalleEvaluacionService){
        this.detalleEvaluacionService = detalleEvaluacionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDetalleEvaluacion(@PathVariable("id") Long evaluacionId){
        ResponseDetalleEvaluacionDTO detalleEvaluacion = detalleEvaluacionService.getDetalleEvaluacion(evaluacionId);
        return ResponseHandler.get(TipoResponse.GET, "lista de detalles de evaluacion", detalleEvaluacion);
    }

}
