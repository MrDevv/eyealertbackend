package com.mrdevv.service.impl;

import com.mrdevv.model.Rol;
import com.mrdevv.payload.dto.rol.ResponseRolDTO;
import com.mrdevv.payload.mapper.RolMapper;
import com.mrdevv.repository.RolRepository;
import com.mrdevv.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements IRolService {

    RolRepository rolRepository;

    @Autowired
    public RolServiceImpl(RolRepository rolRepository){
        this.rolRepository = rolRepository;
    }

    @Override
    public ResponseRolDTO getIdRolUsuario() {
        Rol rol = rolRepository.findIdRolUsuario();
        return RolMapper.toRolDTO(rol);
    }
}
