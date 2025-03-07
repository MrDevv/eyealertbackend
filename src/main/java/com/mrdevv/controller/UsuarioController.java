package com.mrdevv.controller;

import com.mrdevv.model.Usuario;
import com.mrdevv.payload.ResponseHandler;
import com.mrdevv.payload.dto.usuario.AuthUsuarioDTO;
import com.mrdevv.service.IUsuarioService;
import com.mrdevv.utils.TipoResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private IUsuarioService usuarioService;

    @Autowired
    public UsuarioController(IUsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<Object> getUsuarios(){
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return ResponseHandler.get(TipoResponse.GET, "lista de usuarios", usuarios);
    }

    @PostMapping("/auth")
    public ResponseEntity<Object> authUsuario(@Valid @RequestBody AuthUsuarioDTO authUsuarioDTO){
        Usuario usuario = usuarioService.authUsuario(authUsuarioDTO);
        return ResponseHandler.get(TipoResponse.GET, "datos del usuario", usuario);
    }





}
