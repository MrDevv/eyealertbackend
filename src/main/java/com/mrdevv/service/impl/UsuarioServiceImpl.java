package com.mrdevv.service.impl;

import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.usuario.EmailDTO;
import com.mrdevv.payload.dto.usuario.AuthUsuarioDTO;
import com.mrdevv.payload.dto.usuario.ResponseCodeDTO;
import com.mrdevv.payload.dto.usuario.ResponseUsuarioDTO;
import com.mrdevv.payload.mapper.UsuarioMapper;
import com.mrdevv.repository.UsuarioRepository;
import com.mrdevv.service.IEmailService;
import com.mrdevv.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private UsuarioRepository usuarioRepository;
    private IEmailService emailService;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, IEmailService emailService){
        this.usuarioRepository = usuarioRepository;
        this.emailService = emailService;
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

    @Override
    public ResponseCodeDTO sendCodeEmail(EmailDTO emailDTO) {
        int code = (int) (Math.random() * 90000) + 100000;
        String message = "Su código es: " + code;
        emailService.sendCodeEmail(emailDTO.email(), "Código para reestablecer contraseña - EyeAlert", message);
        return new ResponseCodeDTO(code);
    }
}
