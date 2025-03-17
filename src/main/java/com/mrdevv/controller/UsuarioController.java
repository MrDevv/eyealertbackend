package com.mrdevv.controller;

import com.mrdevv.model.Usuario;
import com.mrdevv.payload.ResponseHandler;
import com.mrdevv.payload.dto.evaluacion.ResponseEvaluacionesByUserDTO;
import com.mrdevv.payload.dto.usuario.EmailDTO;
import com.mrdevv.payload.dto.usuario.AuthUsuarioDTO;
import com.mrdevv.payload.dto.usuario.ResponseCodeDTO;
import com.mrdevv.payload.dto.usuario.ResponseUsuarioDTO;
import com.mrdevv.service.IEmailService;
import com.mrdevv.service.IEvaluacionService;
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
    private IEvaluacionService evaluacionService;
    private IEmailService emailService;

    @Autowired
    public UsuarioController(IUsuarioService usuarioService, IEvaluacionService evaluacionService, IEmailService emailService){
        this.usuarioService = usuarioService;
        this.evaluacionService = evaluacionService;
        this.emailService = emailService;
    }

    @GetMapping
    public ResponseEntity<Object> getUsuarios(){
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return ResponseHandler.get(TipoResponse.GET, "lista de usuarios", usuarios);
    }

    @PostMapping("/auth")
    public ResponseEntity<Object> authUsuario(@Valid @RequestBody AuthUsuarioDTO authUsuarioDTO){
        ResponseUsuarioDTO usuario = usuarioService.authUsuario(authUsuarioDTO);
        return ResponseHandler.get(TipoResponse.GET, "datos del usuario", usuario);
    }

    @GetMapping("/{id}/evaluaciones/latest")
    public ResponseEntity<Object> getLastEvaluacionesByUser(@PathVariable Long id){
        ResponseEvaluacionesByUserDTO evaluacionesByUser = evaluacionService.getLastEvaluacionesByUser(id);
        return ResponseHandler.get(TipoResponse.GET, "lista de ultimas 3 evaluacion del usuario", evaluacionesByUser);
    }

    @GetMapping("/{id}/evaluaciones")
    public ResponseEntity<Object> obtenerEvaluacionDeUnUsuario(@PathVariable Long id){
        ResponseEvaluacionesByUserDTO evaluacionesByUser = evaluacionService.getEvaluacionesByUser(id);
        return ResponseHandler.get(TipoResponse.GET, "lista de evaluaciones del usuario", evaluacionesByUser);
    }

    @GetMapping("/{id}/evaluaciones/latest-seven-days")
    public ResponseEntity<Object> obtenerEvaluacionesUltimaSemanaDeUnUsuario(@PathVariable Long id){
        ResponseEvaluacionesByUserDTO lastWeekEvaluationsByUser = evaluacionService.getLastWeekEvaluationsByUser(id);
        return ResponseHandler.get(TipoResponse.GET, "lista de evaluaciones de la última semana del usuario", lastWeekEvaluationsByUser);
    }

    @GetMapping("/{id}/evaluaciones/last-month")
    public ResponseEntity<Object> obtenerEvaluacionesDelUltimoMesDeUnUsuario(@PathVariable(name = "id") Long idUsuario){
        ResponseEvaluacionesByUserDTO evaluacionesUltimoMes = evaluacionService.getLastMonthEvaluationsByUser(idUsuario);
        return ResponseHandler.get(TipoResponse.GET, "lista de evaluaciones de la última semana de un usuario", evaluacionesUltimoMes);
    }

    @PostMapping("/recover-password")
    public ResponseEntity<Object> enviarEmailReestablecerPassword(@RequestBody EmailDTO emailDTO){
        ResponseCodeDTO codeDTO = usuarioService.sendCodeEmail(emailDTO);
        return ResponseHandler.get(TipoResponse.GET, "se envió correctamente el código al correo", codeDTO);
    }

}
