package com.mrdevv.service.impl;

import com.mrdevv.exception.ObjectDuplicateException;
import com.mrdevv.exception.ObjectNotFoundException;
import com.mrdevv.exception.PasswordNotMatchesException;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private UsuarioRepository usuarioRepository;
    private IEmailService emailService;
    private IRolService rolService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, IEmailService emailService, IRolService rolService, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.emailService = emailService;
        this.rolService = rolService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional
    @Override
    public Usuario createUsuario(CreateUsuarioDTO usuarioDTO) {
        validarPassword(usuarioDTO.password(), usuarioDTO.passwordRepetida());
        ResponseRolDTO rolDTO = rolService.getIdRolUsuario();
        Boolean cuestionarioCompleado = false;
        existsByEmail(usuarioDTO.email());
        Usuario usuario = UsuarioMapper.toUsuarioEntity(usuarioDTO, rolDTO, cuestionarioCompleado);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
        usuario.setRol(RolMapper.toRolEntity(rolDTO));
        return usuario;
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

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public void validarPassword(String password, String passwordRepetida){
        if (!password.equals(passwordRepetida)){
            throw new PasswordNotMatchesException(
                    "La propiedad [password] y [password_repetida] no coinciden",
                    "Las contraseñas no coinciden, por favor ingrese contraseñas válidas"
            );
        }
    }
}
