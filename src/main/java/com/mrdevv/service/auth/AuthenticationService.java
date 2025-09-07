package com.mrdevv.service.auth;

import com.mrdevv.exception.ObjectNotFoundException;
import com.mrdevv.model.PasswordResetToken;
import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.usuario.*;
import com.mrdevv.payload.mapper.UsuarioMapper;
import com.mrdevv.repository.PasswordResetTokenRepository;
import com.mrdevv.service.IEmailService;
import com.mrdevv.service.IPasswordResetTokenService;
import com.mrdevv.service.IUsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final IUsuarioService usuarioService;
    private final IEmailService emailService;
    private final IPasswordResetTokenService passwordResetTokenService;
    private final JwtService jwtService;
    private final PasswordResetTokenRepository passwordResetTokenRepository;

    private final HttpServletRequest httpServletRequest;

    public ResponseUsuarioDTO login(@Valid AuthUsuarioDTO authUsuarioDTO){
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                authUsuarioDTO.email(),
                authUsuarioDTO.password()
        );
        try{
            authenticationManager.authenticate(authentication);
        }catch (Exception e){
            throw new ObjectNotFoundException("Credenciales (email o password) incorrectas.", "Correo o contraseña incorrecta, por favor revise los datos ingresados.");
        }

        UserDetails user = usuarioService.findByEmail(authUsuarioDTO.email()).get();
        String jwt = jwtService.generateToken(user);
        return UsuarioMapper.toUsuarioDTO((Usuario) user, jwt);
    }

    public ResponseUsuarioDTO createUsuario(@Valid CreateUsuarioDTO usuarioDTO){
        Usuario usuario = usuarioService.createUsuario(usuarioDTO);
        String jwt = jwtService.generateToken(usuario);
        return UsuarioMapper.toUsuarioDTO(usuario, jwt);
    }

    public ResponseUsuarioDTO validateToken(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String jwt = httpServletRequest.getHeader("Authorization").split(" ")[1];
        String userEmail = (String) authentication.getPrincipal();
        Usuario usuario = usuarioService.findByEmail(userEmail).get();
        return UsuarioMapper.toUsuarioDTO(usuario, jwt);
    }

    @Transactional
    public void sendCodeEmail(EmailDTO emailDTO) {
        Usuario usuario = usuarioService.findByEmail(emailDTO.email())
                .orElseThrow(() -> new ObjectNotFoundException(
                        "El email " + emailDTO.email() + "  no se encontró en la base de datos.",
                        "El email no está asociado a ninguna cuenta."));

        String token = UUID.randomUUID().toString();
        LocalDateTime fechaExpiracion = LocalDateTime.now().plusDays(1);

        passwordResetTokenService.guardarToken(PasswordResetToken.builder().token(token).usuarioId(usuario.getId()).fechaExpiracion(fechaExpiracion).build());

        String urlFront = "https://eyealert.netlify.app/auth/reset-password/";
        String message = "Haz clic en el siguiente enlace para restablecer tu contraseña: " + urlFront + token;
        emailService.sendCodeEmail(emailDTO.email(), "Código para reestablecer contraseña - EyeAlert", message);
    }

    @Transactional
    public void resetPassword(ResetPasswordDTO resetPasswordDTO){
        PasswordResetToken token = passwordResetTokenRepository.findByToken(resetPasswordDTO.token()).orElseThrow( () ->
                new ObjectNotFoundException(
                        "No se encontró el objeto PasswordResetToken en la base de datos",
                        "El token para restablecer la contraseña no es válido o ha vencido")
        );

        if (token.getFechaExpiracion().isBefore(LocalDateTime.now())){
            throw new ObjectNotFoundException(
                    "La fecha de expiración del campo token es mayor a la fecha actual",
                    "El token para restablecer la contraseña ha vencido");
        }

        usuarioService.resetPassword(resetPasswordDTO.newPassword(), token.getUsuarioId());
        passwordResetTokenRepository.deleteById(token.getId());
    }
}
