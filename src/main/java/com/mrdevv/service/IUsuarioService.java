package com.mrdevv.service;

import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.usuario.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IUsuarioService {

    Page<Usuario> getUsuarios(Pageable pageable);

    Usuario createUsuario(CreateUsuarioDTO usuarioDTO);

    ResponseCodeDTO sendCodeEmail(EmailDTO emailDTO);

    void updateEstadoCuestionarioCompletado(Long usuarioId);

    ResponseUsuarioDTO updateUsuario(UpdateUsuarioDTO usuarioDTO, Long usuarioId);

    void updatePassword(UpdatePasswordDTO updatePasswordDTO, Long usuarioId);

    void resetPassword(String newPassword, Long usuarioId);

    void existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);

}
