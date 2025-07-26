package com.mrdevv.controller;

import com.mrdevv.model.Usuario;
import com.mrdevv.payload.ResponseHandler;
import com.mrdevv.payload.dto.ResponseWithPageable;
import com.mrdevv.payload.dto.evaluacion.ResponseEvaluacionesByUserDTO;
import com.mrdevv.payload.dto.quizz.ResponsePuntajeUsuario;
import com.mrdevv.payload.dto.usuario.*;
import com.mrdevv.service.IEmailService;
import com.mrdevv.service.IEvaluacionService;
import com.mrdevv.service.IQuizzService;
import com.mrdevv.service.IUsuarioService;
import com.mrdevv.utils.TipoResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private IUsuarioService usuarioService;
    private IEvaluacionService evaluacionService;
    private IEmailService emailService;
    private IQuizzService quizzService;

    @Autowired
    public UsuarioController(IUsuarioService usuarioService, IEvaluacionService evaluacionService, IEmailService emailService, IQuizzService quizzService){
        this.usuarioService = usuarioService;
        this.evaluacionService = evaluacionService;
        this.emailService = emailService;
        this.quizzService = quizzService;
    }

//    TODO: Corregir metodo: el servicio debe devolver un ResponseWithPageable
    @GetMapping
    public ResponseEntity<Object> getUsuarios(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Usuario> usuarios = usuarioService.getUsuarios(pageable);
        return ResponseHandler.get(TipoResponse.GET, "lista de usuarios", usuarios);
    }

    @GetMapping("/{id}/evaluaciones/latest")
    public ResponseEntity<Object> getLatestEvaluacionesByUser(@PathVariable Long id, @RequestParam(defaultValue = "3") Integer size){
        ResponseEvaluacionesByUserDTO evaluacionesByUser = evaluacionService.getLastestEvaluacionesByUser(id, size);
        return ResponseHandler.get(TipoResponse.GET, "lista de ultimas " + size + " evaluacion del usuario", evaluacionesByUser);
    }

    @GetMapping("/{id}/evaluaciones")
    public ResponseEntity<Object> obtenerEvaluacionDeUnUsuario(@PathVariable Long id, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size){
        ResponseWithPageable evaluacionesByUser = evaluacionService.getEvaluacionesByUser(id, page, size);
        return ResponseHandler.get(TipoResponse.GET, "lista de evaluaciones del usuario", evaluacionesByUser);
    }

    @GetMapping("/{id}/evaluaciones/latest-seven-days")
    public ResponseEntity<Object> obtenerEvaluacionesUltimaSemanaDeUnUsuario(@PathVariable Long id, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size){
        ResponseWithPageable lastWeekEvaluationsByUser = evaluacionService.getLastWeekEvaluationsByUser(id, page, size);
        return ResponseHandler.get(TipoResponse.GET, "lista de evaluaciones de la última semana del usuario", lastWeekEvaluationsByUser);
    }

    @GetMapping("/{id}/evaluaciones/last-month")
    public ResponseEntity<Object> obtenerEvaluacionesDelUltimoMesDeUnUsuario(@PathVariable(name = "id") Long idUsuario, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size){
        ResponseWithPageable evaluacionesUltimoMes = evaluacionService.getLastMonthEvaluationsByUser(idUsuario, page, size);
        return ResponseHandler.get(TipoResponse.GET, "lista de evaluaciones de la última semana de un usuario", evaluacionesUltimoMes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizarUsuario(@RequestBody @Valid UpdateUsuarioDTO usuarioDTO, @PathVariable(name = "id") Long usuarioId){
        ResponseUsuarioDTO usuarioUpdatedDTO = usuarioService.updateUsuario(usuarioDTO, usuarioId);
        return ResponseHandler.get(TipoResponse.UPDATE, "se actualizó el usuario correctamente", usuarioUpdatedDTO);
    }

    @GetMapping("/{id}/puntaje")
    public ResponseEntity<Object> obtenerPuntajeUsuario(@PathVariable(name = "id") Long usuarioId){
        ResponsePuntajeUsuario puntajeUsuario = quizzService.obtenerPuntajeUsuario(usuarioId);
        return ResponseHandler.get(TipoResponse.GET, "puntaje del usuario", puntajeUsuario);
    }

    @PatchMapping("/{id}/update-password")
    public ResponseEntity<Object> actualizarPassword(@RequestBody UpdatePasswordDTO updatePasswordDTO, @PathVariable(name = "id") Long usuarioId){
        usuarioService.updatePassword(updatePasswordDTO, usuarioId);
        return ResponseHandler.get(TipoResponse.PATCH, "contraseña actualizada correctamente", null);
    }

    @PostMapping("/recover-password")
    public ResponseEntity<Object> enviarEmailReestablecerPassword(@RequestBody EmailDTO emailDTO){
        ResponseCodeDTO codeDTO = usuarioService.sendCodeEmail(emailDTO);
        return ResponseHandler.get(TipoResponse.GET, "se envió correctamente el código al correo", codeDTO);
    }

    @PatchMapping("/{id}/reset-password")
    public ResponseEntity<Object> reestablecerPassword(@RequestBody ResetPasswordDTO updatePasswordDTO, @PathVariable(name = "id") Long idUsuario){
        System.out.println(idUsuario);
        System.out.println(updatePasswordDTO.newPassword());
        usuarioService.resetPassword(updatePasswordDTO.newPassword(), idUsuario);
        return ResponseHandler.get(TipoResponse.PATCH, "se actualizó correctamente la contraseña del usuario", null);
    }

}
