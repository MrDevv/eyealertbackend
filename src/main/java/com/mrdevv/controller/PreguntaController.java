package com.mrdevv.controller;

import com.mrdevv.model.Pregunta;
import com.mrdevv.payload.ResponseHandler;
import com.mrdevv.payload.dto.pregunta.ResponsePreguntasDTO;
import com.mrdevv.service.IPreguntaService;
import com.mrdevv.utils.TipoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

    private IPreguntaService preguntaService;

    @Autowired
    public PreguntaController(IPreguntaService preguntaService){
        this.preguntaService = preguntaService;
    }

    @GetMapping
    public ResponseEntity<Object> getPreguntas(){
        List<ResponsePreguntasDTO> preguntas = preguntaService.getPreguntas();
        return ResponseHandler.get(TipoResponse.GET, "lista de preguntas", preguntas);
    }
}
