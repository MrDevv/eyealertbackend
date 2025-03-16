package com.mrdevv.service;

import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.usuario.AuthUsuarioDTO;
import com.mrdevv.payload.dto.usuario.ResponseUsuarioDTO;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> getUsuarios();

    ResponseUsuarioDTO authUsuario(AuthUsuarioDTO authUsuarioDTO);

}
