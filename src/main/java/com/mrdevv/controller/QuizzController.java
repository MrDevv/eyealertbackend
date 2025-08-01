package com.mrdevv.controller;

import com.mrdevv.model.Quizz;
import com.mrdevv.payload.ResponseHandler;
import com.mrdevv.payload.dto.ResponseWithPageable;
import com.mrdevv.payload.dto.quizz.CreateQuizzDTO;
import com.mrdevv.payload.dto.quizz.ResponseQuizzDTO;
import com.mrdevv.payload.dto.quizz.ResponseRankingDTO;
import com.mrdevv.service.IQuizzService;
import com.mrdevv.utils.TipoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quizzes")
public class QuizzController {

    private IQuizzService quizzService;

    @Autowired
    public QuizzController(IQuizzService quizzService){
        this.quizzService = quizzService;
    }

    @GetMapping
    public ResponseEntity<Object> listarQuizzes(@RequestParam(defaultValue = "0", required = false) Integer page, @RequestParam(defaultValue = "10", required = false) Integer size){
        Pageable pageable = PageRequest.of(page, size);
        ResponseWithPageable<Quizz> quizzes = quizzService.listarQuizzes(pageable);
        return ResponseHandler.get(TipoResponse.GET, "lista de quizzes", quizzes);
    }

    @GetMapping("/ranking")
    public ResponseEntity<Object> obtenerRanking(){
        ResponseRankingDTO rankingList = quizzService.obtenerRanking();
        return ResponseHandler.get(TipoResponse.GET, "ranking del mes actual", rankingList);
    }

    @PostMapping
    public ResponseEntity<Object> guardarQuizz(@RequestBody CreateQuizzDTO createQuizzDTO){
        ResponseQuizzDTO quizz = quizzService.crearQuizz(createQuizzDTO);
        return ResponseHandler.get(TipoResponse.CREATE, "se guardó correctamente ", quizz);
    }
}