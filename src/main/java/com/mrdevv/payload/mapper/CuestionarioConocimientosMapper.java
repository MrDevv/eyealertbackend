package com.mrdevv.payload.mapper;

import com.mrdevv.model.CuestionarioConocimientos;
import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.cuestionarioConocimientos.CreateCuestionarioConocimientos;
import com.mrdevv.payload.dto.cuestionarioConocimientos.ResponseCuestionarioConocimientosDTO;
import com.mrdevv.payload.dto.cuestionarioConocimientos.ResponseIndiceConocimientoDTO;
import com.mrdevv.payload.dto.usuario.ResponseUsuarioSimpleDTO;

import java.util.List;

public class CuestionarioConocimientosMapper {


    public static List<ResponseCuestionarioConocimientosDTO> toListResponseCuestionarioConocimientosDTO(List<CuestionarioConocimientos> cuestionarioConocimientosList) {
        return cuestionarioConocimientosList.stream().map(cuestionarioConocimientos ->
                new ResponseCuestionarioConocimientosDTO(
                        cuestionarioConocimientos.getId(),
                        cuestionarioConocimientos.getFecha(),
                        cuestionarioConocimientos.getUsuario().getNombres() + " " + cuestionarioConocimientos.getUsuario().getApellidos(),
                        cuestionarioConocimientos.getPuntajeObtenido()
                )

        ).toList();
    }

    public static ResponseCuestionarioConocimientosDTO toResponseCuestionarioConocimientosDTO(CuestionarioConocimientos cuestionarioConocimientos) {
        return new ResponseCuestionarioConocimientosDTO(
                cuestionarioConocimientos.getId(),
                cuestionarioConocimientos.getFecha(),
                cuestionarioConocimientos.getUsuario().getNombres() + " " + cuestionarioConocimientos.getUsuario().getApellidos(),
                cuestionarioConocimientos.getPuntajeObtenido()
        );
    }

    public static CuestionarioConocimientos toCuestionarioConocimientosEntity(CreateCuestionarioConocimientos cuestionarioConocimientos, Integer puntajeObtenido){
        return CuestionarioConocimientos.builder()
                .usuario(Usuario.builder().id(cuestionarioConocimientos.usuarioId()).build())
                .puntajeObtenido(puntajeObtenido)
                .build();
    }

    public static ResponseIndiceConocimientoDTO toResponseIndiceConocimientoDTO(Object[] datosIndiceConocimiento){
        Integer puntajeTotalPosible = ((Number) datosIndiceConocimiento[2]).intValue();

        if (datosIndiceConocimiento[0]!=null){
            Integer puntajeTotal = ((Number) datosIndiceConocimiento[0]).intValue();
            Integer numeroParticipantes = ((Number) datosIndiceConocimiento[1]).intValue();
            Double indiceConocimiento = ((Number) datosIndiceConocimiento[3]).doubleValue();

            return new ResponseIndiceConocimientoDTO(
                    puntajeTotal,
                    numeroParticipantes,
                    puntajeTotalPosible,
                    indiceConocimiento
            );
        }

        return new ResponseIndiceConocimientoDTO(0,
                0,
                puntajeTotalPosible,
                0.0
        );
    }

}
