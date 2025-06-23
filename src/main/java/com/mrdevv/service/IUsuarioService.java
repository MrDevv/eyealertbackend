package com.mrdevv.service;

import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.usuario.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    Page<Usuario> getUsuarios(Pageable pageable);

    Usuario createUsuario(CreateUsuarioDTO usuarioDTO);

    ResponseCodeDTO sendCodeEmail(EmailDTO emailDTO);

    void updateEstadoCuestionarioCompletado(Long usuarioId);

    void updatePassword(String newPassword, Long usuarioId);

    void existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);

}
