package com.mrdevv.controller;


import com.mrdevv.payload.ResponseHandler;
import com.mrdevv.payload.dto.datoInformativo.ResponseDatoInformativoDTO;
import com.mrdevv.service.IDatoInformativoService;
import com.mrdevv.utils.TipoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/datosInformativos")
public class DatoInformativoController {

    private IDatoInformativoService datoInformativoService;

    @Autowired
    public DatoInformativoController(IDatoInformativoService datoInformativoService){
        this.datoInformativoService = datoInformativoService;
    }


    @GetMapping("/aleatorios")
    public ResponseEntity<Object> getDatosInformativosAleatorios(){
        List<ResponseDatoInformativoDTO> datosInformativos = datoInformativoService.getDatosInformativoAleatorio();
        return ResponseHandler.get(TipoResponse.GET, "lista de datos informativos aleatorios", datosInformativos);
    }

    @GetMapping
    public ResponseEntity<Object> getDatosInformativos(){
        List<ResponseDatoInformativoDTO> datoInformativo = datoInformativoService.getAllDatosInformativos();
        return ResponseHandler.get(TipoResponse.GET, "lista de todos los datos informativos", datoInformativo);
    }

    @GetMapping("/aleatorio")
    public ResponseEntity<Object> obtenerDatoInformativo(){
        ResponseDatoInformativoDTO datoInformativo = datoInformativoService.getDatoInformativoRandom();
        return ResponseHandler.get(TipoResponse.GET, "datos del dato informativo aleatorio", datoInformativo);
    }

}
