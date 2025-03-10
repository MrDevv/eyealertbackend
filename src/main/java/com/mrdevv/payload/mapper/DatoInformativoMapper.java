package com.mrdevv.payload.mapper;

import com.mrdevv.model.DatoInformativo;
import com.mrdevv.payload.dto.datoInformativo.ResponseDatoInformativoDTO;

import java.util.ArrayList;
import java.util.List;

public class DatoInformativoMapper {


    public static List<ResponseDatoInformativoDTO> toResponseDatosInformativosDTO(List<DatoInformativo> datosInformativos) {

        List<ResponseDatoInformativoDTO> listDatosInformativosDTO = new ArrayList<>();

        listDatosInformativosDTO = datosInformativos.stream().map(datoInformativo -> new ResponseDatoInformativoDTO(
                        datoInformativo.getId(),
                        datoInformativo.getTitulo(),
                        datoInformativo.getDescripcion(),
                        datoInformativo.getFuente(),
                        datoInformativo.getFuenteMultimedia()
                )
        ).toList();

        return listDatosInformativosDTO;
    }
}
