package com.mrdevv.controller;

import com.mrdevv.payload.ResponseHandler;
import com.mrdevv.payload.dto.cuestionarioConocimientos.CreateCuestionarioConocimientos;
import com.mrdevv.payload.dto.cuestionarioConocimientos.ResponseConfigCuestionarioDTO;
import com.mrdevv.payload.dto.cuestionarioConocimientos.ResponseCuestionarioConocimientosDTO;
import com.mrdevv.service.IConfigCuestionarioService;
import com.mrdevv.service.ICuestionarioConocimientosService;
import com.mrdevv.utils.TipoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuestionarioConocimientos")
public class CuestionarioController {

    private IConfigCuestionarioService configCuestionario;
    private ICuestionarioConocimientosService cuestionarioConocimientosService;

    @Autowired
    public CuestionarioController(IConfigCuestionarioService configCuestionario, ICuestionarioConocimientosService cuestionarioConocimientosService){
        this.configCuestionario = configCuestionario;
        this.cuestionarioConocimientosService = cuestionarioConocimientosService;
    }

    @GetMapping("/dias-espera")
    public ResponseEntity<Object> getDiasEsperaCuestionario(){
        ResponseConfigCuestionarioDTO configCuestionarioDTO = configCuestionario.getDiasEsperaCuestionario();
        return ResponseHandler.get(TipoResponse.GET, "dias de espera para el cuestionario", configCuestionarioDTO);
    }

    @GetMapping
    public ResponseEntity<Object> getCuestionariosConocimientos(){
        List<ResponseCuestionarioConocimientosDTO> cuestionarios = cuestionarioConocimientosService.getCuestionariosConocimientos();
        return ResponseHandler.get(TipoResponse.GET, "lista de cuestionarios de conocomientos sobre el glaucoma", cuestionarios);
    }

    @PostMapping
    public ResponseEntity<Object> createCuestionarioConocimientos(@RequestBody CreateCuestionarioConocimientos cuestionarioConocimientos){
        ResponseCuestionarioConocimientosDTO cuestionario = cuestionarioConocimientosService.createCuestionarioConocimientos(cuestionarioConocimientos);
        return ResponseHandler.get(TipoResponse.CREATE, "se creo correctamente el cuestionario de conocimientos sobre el glaucoma", cuestionario);
    }

}
