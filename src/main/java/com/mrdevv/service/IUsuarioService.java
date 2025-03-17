package com.mrdevv.service;

import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.usuario.EmailDTO;
import com.mrdevv.payload.dto.usuario.AuthUsuarioDTO;
import com.mrdevv.payload.dto.usuario.ResponseCodeDTO;
import com.mrdevv.payload.dto.usuario.ResponseUsuarioDTO;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> getUsuarios();

    ResponseUsuarioDTO authUsuario(AuthUsuarioDTO authUsuarioDTO);

    ResponseCodeDTO sendCodeEmail(EmailDTO emailDTO);

}
