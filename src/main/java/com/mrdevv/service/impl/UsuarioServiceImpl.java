package com.mrdevv.service.impl;

import com.mrdevv.model.Usuario;
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
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, IEmailService emailService, IRolService rolService){
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
        Usuario usuario = usuarioRepository.authUsuario(authUsuarioDTO.email(), authUsuarioDTO.password());
        return UsuarioMapper.toUsuarioDTO(usuario);
    }

    @Transactional
    @Override
    public ResponseUsuarioDTO createUsuario(CreateUsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.save(UsuarioMapper.toUsuarioEntity(usuarioDTO, rolService.getIdRolUsuario()));
        return UsuarioMapper.toUsuarioDTO(usuario);
    }

    @Override
    public ResponseCodeDTO sendCodeEmail(EmailDTO emailDTO) {
        int code = (int) (Math.random() * 90000) + 100000;
        String message = "Su código es: " + code;
        emailService.sendCodeEmail(emailDTO.email(), "Código para reestablecer contraseña - EyeAlert", message);
        return new ResponseCodeDTO(code);
    }
}
