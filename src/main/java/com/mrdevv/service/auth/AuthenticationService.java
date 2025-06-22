package com.mrdevv.service.auth;

import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.usuario.AuthUsuarioDTO;
import com.mrdevv.payload.dto.usuario.ResponseUsuarioDTO;
import com.mrdevv.payload.mapper.UsuarioMapper;
import com.mrdevv.service.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    private AuthenticationManager authenticationManager;
    private IUsuarioService usuarioService;
    private JwtService jwtService;

    @Autowired
    public AuthenticationService(AuthenticationManager authenticationManager, IUsuarioService usuarioService, JwtService jwtService){
        this.authenticationManager = authenticationManager;
        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
    }

    public Map<String, Object> generateExtraClaims(Usuario usuario){
        Map<String, Object> extraClaims = new HashMap<>();

        extraClaims.put("name", usuario.getNombres());
        extraClaims.put("role", usuario.getRol().getDescripcion());

        return extraClaims;
    }

    public ResponseUsuarioDTO login(@Valid AuthUsuarioDTO authUsuarioDTO){
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                authUsuarioDTO.email(),
                authUsuarioDTO.password()
        );
        authenticationManager.authenticate(authentication);
        UserDetails user = usuarioService.findByEmail(authUsuarioDTO.email()).get();
        String jwt = jwtService.generateToken(user, generateExtraClaims((Usuario) user));
        return UsuarioMapper.toUsuarioDTO((Usuario) user, jwt);
    }
}
