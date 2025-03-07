package com.mrdevv.service.impl;

import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.usuario.AuthUsuarioDTO;
import com.mrdevv.repository.UsuarioRepository;
import com.mrdevv.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario authUsuario(AuthUsuarioDTO authUsuarioDTO) {
        return usuarioRepository.authUsuario(authUsuarioDTO.email(), authUsuarioDTO.password());
    }
}
