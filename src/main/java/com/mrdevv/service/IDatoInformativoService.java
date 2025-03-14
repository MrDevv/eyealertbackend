package com.mrdevv.service;

import com.mrdevv.payload.dto.datoInformativo.ResponseDatoInformativoDTO;

import java.util.List;

public interface IDatoInformativoService {

    public List<ResponseDatoInformativoDTO> getDatosInformativoAleatorio();

    public List<ResponseDatoInformativoDTO> getAllDatosInformativos();

}
