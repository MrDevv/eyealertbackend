package com.mrdevv.controller;

import com.mrdevv.payload.ResponseHandler;
import com.mrdevv.payload.dto.usuario.AuthUsuarioDTO;
import com.mrdevv.payload.dto.usuario.ResponseUsuarioDTO;
import com.mrdevv.service.IUsuarioService;
import com.mrdevv.service.auth.AuthenticationService;
import com.mrdevv.utils.TipoResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }


    @PostMapping("/login")
    public ResponseEntity<Object> authUsuario(@Valid @RequestBody AuthUsuarioDTO authUsuarioDTO){
        ResponseUsuarioDTO usuario = authenticationService.login(authUsuarioDTO);
        return ResponseHandler.get(TipoResponse.GET, "datos del usuario", usuario);
    }

}
