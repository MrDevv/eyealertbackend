package com.mrdevv.service.impl;

import com.mrdevv.model.ConfigCuestionario;
import com.mrdevv.payload.dto.cuestionarioConocimientos.ResponseConfigCuestionarioDTO;
import com.mrdevv.payload.mapper.ConfigCuestionarioMapper;
import com.mrdevv.repository.ConfigCuestionarioRepository;
import com.mrdevv.service.IConfigCuestionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigCuestionarioServiceImpl implements IConfigCuestionarioService {

    private ConfigCuestionarioRepository configCuestionarioRepository;

    @Autowired
    public ConfigCuestionarioServiceImpl(ConfigCuestionarioRepository configCuestionarioRepository){
        this.configCuestionarioRepository = configCuestionarioRepository;
    }

    public ResponseConfigCuestionarioDTO getDiasEsperaCuestionario(){
        ConfigCuestionario configCuestionario = configCuestionarioRepository.findFirstByOrderByIdAsc();
        return ConfigCuestionarioMapper.toResponseConfigCuestionarioDTO(configCuestionario);
    }

}
