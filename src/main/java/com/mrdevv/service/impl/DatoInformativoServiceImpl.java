package com.mrdevv.service.impl;

import com.mrdevv.model.DatoInformativo;
import com.mrdevv.payload.dto.datoInformativo.ResponseDatoInformativoDTO;
import com.mrdevv.payload.mapper.DatoInformativoMapper;
import com.mrdevv.repository.DatoInformativoRepostory;
import com.mrdevv.service.IDatoInformativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatoInformativoServiceImpl implements IDatoInformativoService {

    private DatoInformativoRepostory datoInformativoRepostory;

    @Autowired
    public DatoInformativoServiceImpl(DatoInformativoRepostory datoInformativoRepostory){
        this.datoInformativoRepostory = datoInformativoRepostory;
    }


    @Override
    public List<ResponseDatoInformativoDTO> getDatosInformativoAleatorio() {
        List<DatoInformativo> datoInformativos = datoInformativoRepostory.findTop3Random();
        return DatoInformativoMapper.toResponseDatosInformativosDTO(datoInformativos);
    }
}
