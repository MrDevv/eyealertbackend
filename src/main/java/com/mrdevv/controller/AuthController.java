package com.mrdevv.controller;

import com.mrdevv.payload.ResponseHandler;
import com.mrdevv.payload.dto.usuario.AuthUsuarioDTO;
import com.mrdevv.payload.dto.usuario.CreateUsuarioDTO;
import com.mrdevv.payload.dto.usuario.ResponseUsuarioDTO;
import com.mrdevv.service.IUsuarioService;
import com.mrdevv.service.auth.AuthenticationService;
import com.mrdevv.utils.TipoResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/login")
    public ResponseEntity<Object> authUsuario(@Valid @RequestBody AuthUsuarioDTO authUsuarioDTO) {
        ResponseUsuarioDTO usuario = authenticationService.login(authUsuarioDTO);
        return ResponseHandler.get(TipoResponse.GET, "datos del usuario", usuario);
    }

    @PostMapping("/create-usuario")
    public ResponseEntity<Object> crearUsuario(@Valid @RequestBody CreateUsuarioDTO usuarioDTO) {
        ResponseUsuarioDTO usuario = authenticationService.createUsuario(usuarioDTO);
        return ResponseHandler.get(TipoResponse.CREATE, "usuario creado", usuario);
    }

    @GetMapping("/validate-token")
    public ResponseEntity<Object> validarToken(){
        ResponseUsuarioDTO usuarioDTO = authenticationService.validateToken();
        return ResponseHandler.get(TipoResponse.GET, "datos del usuario logeado", usuarioDTO);
    }

}
