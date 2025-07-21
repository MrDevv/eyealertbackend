package com.mrdevv.service;

import com.mrdevv.payload.dto.ResponseWithPageable;
import com.mrdevv.payload.dto.datoInformativo.ResponseDatoInformativoDTO;

import java.util.List;

public interface IDatoInformativoService {

    public List<ResponseDatoInformativoDTO> getDatosInformativoAleatorio(Integer size);

    public ResponseWithPageable getAllDatosInformativos(Integer page, Integer size);

    public ResponseDatoInformativoDTO getDatoInformativoRandom();

}
