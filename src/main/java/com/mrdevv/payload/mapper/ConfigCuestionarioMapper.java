package com.mrdevv.payload.mapper;

import com.mrdevv.model.ConfigCuestionario;
import com.mrdevv.payload.dto.cuestionarioConocimientos.ResponseConfigCuestionarioDTO;

public class ConfigCuestionarioMapper {

    public static ResponseConfigCuestionarioDTO toResponseConfigCuestionarioDTO(ConfigCuestionario configCuestionario){
        return new ResponseConfigCuestionarioDTO(
                configCuestionario.getId(),
                configCuestionario.getDiasEspera()
        );
    }
}
