package com.mrdevv.payload.dto.quizz;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrdevv.payload.dto.usuario.ResponseUsuarioSimpleDTO;

import java.time.LocalDateTime;

public record ResponseQuizz(
        Integer quizzId,
        Integer puntaje,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fecha,
        ResponseUsuarioSimpleDTO usuario
) {
}
