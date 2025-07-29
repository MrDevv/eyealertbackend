package com.mrdevv.controller;

import com.mrdevv.model.PreguntaQuizz;
import com.mrdevv.payload.ResponseHandler;
import com.mrdevv.payload.dto.quizz.ResponsePreguntaQuizzDTO;
import com.mrdevv.service.IPreguntaQuizz;
import com.mrdevv.utils.TipoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/preguntas-quizz")
public class PreguntaQuizzController {

    private IPreguntaQuizz preguntaQuizz;

    @Autowired
    public PreguntaQuizzController(IPreguntaQuizz preguntaQuizz){
        this.preguntaQuizz = preguntaQuizz;
    }

    @GetMapping
    public ResponseEntity<Object> obtenerPreguntasQuizz(@RequestParam(defaultValue = "15") Integer limit){
        List<ResponsePreguntaQuizzDTO> preguntasQuizz = this.preguntaQuizz.obtenerPreguntasQuizz(limit);
        return ResponseHandler.get(TipoResponse.GET, "lista de preguntas quizz", preguntasQuizz);
    }

}
