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
import com.mrdevv.service.auth.AuthenticationService;
import com.mrdevv.service.auth.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private UsuarioRepository usuarioRepository;
    private IEmailService emailService;
    private IRolService rolService;
    private PasswordEncoder passwordEncoder;

    private JwtService jwtService;
//    private AuthenticationService authenticationService;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, IEmailService emailService, IRolService rolService, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.emailService = emailService;
        this.rolService = rolService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
//        this.authenticationService = authenticationService;
    }

    @Override
    public Page<Usuario> getUsuarios(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
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

    public Map<String, Object> generateExtraClaims(Usuario usuario){
        Map<String, Object> extraClaims = new HashMap<>();

        extraClaims.put("name", usuario.getNombres());
        extraClaims.put("role", "ROLE_" + usuario.getRol().getDescripcion());

        return extraClaims;
    }

    @Transactional
    @Override
    public ResponseUsuarioDTO updateUsuario(UpdateUsuarioDTO usuarioDTO, Long usuarioId) {
        Usuario usuario = findById(usuarioId);
        usuario.setApellidos(usuarioDTO.apellidos());
        usuario.setNombres(usuarioDTO.nombres());
        usuario.setEmail(usuarioDTO.email());

        Usuario usuarioUpdate = usuarioRepository.save(usuario);
        String jwt = jwtService.generateToken(usuarioUpdate);
        return UsuarioMapper.toUsuarioDTO(usuarioUpdate, jwt);
    }

    @Transactional
    @Override
    public void updatePassword(UpdatePasswordDTO updatePasswordDTO, Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() ->
                new ObjectNotFoundException(
                        "El usuario con ID [" + usuarioId + "] no se encontró en la base de datos.",
                        "No se encontró a este usuario."));

        if (!passwordEncoder.matches(updatePasswordDTO.passwordCurrent(), usuario.getPassword())){
            throw new PasswordNotMatchesException(
                    "El password ingresado no coincide con el password en la base de datos",
                    "La contraseña ingresada no coincide con la contraseña actual, verifique los datos."
            );
        }

        validarPassword(updatePasswordDTO.newPassword(), updatePasswordDTO.repeatedPassword());
        usuarioRepository.updatePassword(passwordEncoder.encode(updatePasswordDTO.newPassword()), usuarioId);
    }

    @Transactional
    @Override
    public void resetPassword(String newPassword, Long usuarioId) {
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

    public Usuario findById(Long usuarioId){
        return usuarioRepository.findById(usuarioId).orElseThrow(() -> new ObjectNotFoundException(
                "El objecto [MAE_USUARIO] con ID " + usuarioId + " no fue encontrado en la base de datos",
                "El usuario con ID " + usuarioId + " no fue encontrado"));
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
