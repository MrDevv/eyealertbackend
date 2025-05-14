package com.mrdevv.service;

import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.usuario.*;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> getUsuarios();

    ResponseUsuarioDTO authUsuario(AuthUsuarioDTO authUsuarioDTO);

    ResponseUsuarioDTO createUsuario(CreateUsuarioDTO usuarioDTO);

    ResponseCodeDTO sendCodeEmail(EmailDTO emailDTO);

    void updateEstadoCuestionarioCompletado(Long usuarioId);

    void existsByEmail(String email);

}
