package com.mrdevv.service;

import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.usuario.AuthUsuarioDTO;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> getUsuarios();

    Usuario authUsuario(AuthUsuarioDTO authUsuarioDTO);

}
