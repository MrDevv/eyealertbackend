package com.mrdevv.payload.mapper;

import com.mrdevv.model.DatoInformativo;
import com.mrdevv.payload.dto.PageableData;
import com.mrdevv.payload.dto.ResponseWithPageable;
import com.mrdevv.payload.dto.datoInformativo.ResponseDatoInformativoDTO;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class DatoInformativoMapper {


    public static ResponseDatoInformativoDTO toResponseDatoInformativoDTO(DatoInformativo datoInformativo){
        return new ResponseDatoInformativoDTO(
                datoInformativo.getId(),
                datoInformativo.getTitulo(),
                datoInformativo.getDescripcion(),
                datoInformativo.getFuente(),
                datoInformativo.getFuenteMultimedia()
        );
    }

    public static ResponseWithPageable toResponseDatosInformativosDTO(Page<DatoInformativo> datosInformativos) {

        List<ResponseDatoInformativoDTO> listDatosInformativosDTO = new ArrayList<>();
        PageableData pageableData = PageableMapper.toPageableData(datosInformativos);

        listDatosInformativosDTO = datosInformativos.stream().map(datoInformativo -> new ResponseDatoInformativoDTO(
                        datoInformativo.getId(),
                        datoInformativo.getTitulo(),
                        datoInformativo.getDescripcion(),
                        datoInformativo.getFuente(),
                        datoInformativo.getFuenteMultimedia()
                )
        ).toList();

        return new ResponseWithPageable(
                listDatosInformativosDTO,
                pageableData
        );
    }

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
