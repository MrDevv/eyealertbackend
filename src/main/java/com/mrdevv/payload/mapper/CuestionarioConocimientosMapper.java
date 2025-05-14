package com.mrdevv.payload.mapper;

import com.mrdevv.model.CuestionarioConocimientos;
import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.cuestionarioConocimientos.CreateCuestionarioConocimientos;
import com.mrdevv.payload.dto.cuestionarioConocimientos.ResponseCuestionarioConocimientosDTO;
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

}
