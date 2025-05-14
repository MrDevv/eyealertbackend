package com.mrdevv.service.impl;

import com.mrdevv.exception.ObjectDuplicateException;
import com.mrdevv.exception.ObjectNotFoundException;
import com.mrdevv.model.Rol;
import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.rol.ResponseRolDTO;
import com.mrdevv.payload.dto.usuario.*;
import com.mrdevv.payload.mapper.RolMapper;
import com.mrdevv.payload.mapper.UsuarioMapper;
import com.mrdevv.repository.UsuarioRepository;
import com.mrdevv.service.IEmailService;
import com.mrdevv.service.IRolService;
import com.mrdevv.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private UsuarioRepository usuarioRepository;
    private IEmailService emailService;
    private IRolService rolService;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, IEmailService emailService, IRolService rolService) {
        this.usuarioRepository = usuarioRepository;
        this.emailService = emailService;
        this.rolService = rolService;
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public ResponseUsuarioDTO authUsuario(AuthUsuarioDTO authUsuarioDTO) {
        Usuario usuario = usuarioRepository.authUsuario(authUsuarioDTO.email(), authUsuarioDTO.password()).orElse(null);
        if (usuario == null) {
            return null;
        }
        return UsuarioMapper.toUsuarioDTO(usuario);
    }

    @Transactional
    @Override
    public ResponseUsuarioDTO createUsuario(CreateUsuarioDTO usuarioDTO) {
        ResponseRolDTO rolDTO = rolService.getIdRolUsuario();
        Boolean cuestionarioCompleado = false;
        existsByEmail(usuarioDTO.email());
        Usuario usuario = usuarioRepository.save(UsuarioMapper.toUsuarioEntity(usuarioDTO, rolDTO, cuestionarioCompleado));
        usuario.setRol(RolMapper.toRolEntity(rolDTO));
        return UsuarioMapper.toUsuarioDTO(usuario);
    }

    @Override
    public ResponseCodeDTO sendCodeEmail(EmailDTO emailDTO) {
        Usuario usuario = usuarioRepository.findByEmail(emailDTO.email())
                .orElseThrow(() -> new ObjectNotFoundException(
                        "El email " + emailDTO.email() + "  no se encontró en la base de datos.",
                        "El email no está asociado a ninguna cuenta."));

        int code = (int) (Math.random() * 90000) + 100000;
        String message = "Su código es: " + code;
        emailService.sendCodeEmail(emailDTO.email(), "Código para reestablecer contraseña - EyeAlert", message);
        return new ResponseCodeDTO(code, usuario.getId());
    }

    @Transactional
    @Override
    public void updateEstadoCuestionarioCompletado(Long usuarioId) {
        usuarioRepository.updateEstadoCuestionarioCompletado(usuarioId);
    }

    @Transactional
    @Override
    public void updatePassword(String newPassword, Long usuarioId) {
        usuarioRepository.updatePassword(newPassword, usuarioId);
    }

    @Override
    public void existsByEmail(String email) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new ObjectDuplicateException(
                    "El usuario con email " + email + " ya se encuentra registrado.",
                    "Entrada duplicada " + email + " para la llave mae_usuario.EMAIL."
            );
        }
    }
}
