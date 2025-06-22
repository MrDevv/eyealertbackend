package com.mrdevv.service;

import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.usuario.*;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    List<Usuario> getUsuarios();

//    ResponseUsuarioDTO createUsuario(CreateUsuarioDTO usuarioDTO);

    ResponseCodeDTO sendCodeEmail(EmailDTO emailDTO);

    void updateEstadoCuestionarioCompletado(Long usuarioId);

    void updatePassword(String newPassword, Long usuarioId);

    void existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);

}
