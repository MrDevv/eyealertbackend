package com.mrdevv.service.impl;

import com.mrdevv.model.DatoInformativo;
import com.mrdevv.payload.dto.ResponseWithPageable;
import com.mrdevv.payload.dto.datoInformativo.ResponseDatoInformativoDTO;
import com.mrdevv.payload.mapper.DatoInformativoMapper;
import com.mrdevv.repository.DatoInformativoRepostory;
import com.mrdevv.service.IDatoInformativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<ResponseDatoInformativoDTO> getDatosInformativoAleatorio(Integer size) {
        List<DatoInformativo> datoInformativos = datoInformativoRepostory.findTopRandom(size);
        return DatoInformativoMapper.toResponseDatosInformativosDTO(datoInformativos);
    }

    @Override
    public ResponseWithPageable getAllDatosInformativos(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<DatoInformativo> datoInformativos = datoInformativoRepostory.findAllDatosInformativos(pageable);
        return DatoInformativoMapper.toResponseDatosInformativosDTO(datoInformativos);
    }

    @Override
    public ResponseDatoInformativoDTO getDatoInformativoRandom() {
        DatoInformativo datoInformativo = datoInformativoRepostory.findDatoInformativoRandom();
        return DatoInformativoMapper.toResponseDatoInformativoDTO(datoInformativo);
    }
}
