package com.mrdevv.payload.mapper;

import com.mrdevv.model.Rol;
import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.rol.ResponseRolDTO;
import com.mrdevv.payload.dto.usuario.CreateUsuarioDTO;
import com.mrdevv.payload.dto.usuario.ResponseUsuarioDTO;

public class UsuarioMapper {

    public static ResponseUsuarioDTO toUsuarioDTO(Usuario usuario){
        return new ResponseUsuarioDTO(
                usuario.getId(),
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getEmail(),
                usuario.getRol().getDescripcion(),
                usuario.getCuestionarioCompleado(),
                usuario.getFecha()
        );
    }

    public static Usuario toUsuarioEntity(CreateUsuarioDTO usuarioDTO, ResponseRolDTO rolDTO, Boolean cuestionarioCompletado){
        return Usuario.builder()
                .nombres(usuarioDTO.nombres())
                .apellidos(usuarioDTO.apellidos())
                .email(usuarioDTO.email())
                .password(usuarioDTO.password())
                .rol(Rol.builder().id(rolDTO.id()).build())
                .cuestionarioCompleado(cuestionarioCompletado)
                .build();
    }
}
