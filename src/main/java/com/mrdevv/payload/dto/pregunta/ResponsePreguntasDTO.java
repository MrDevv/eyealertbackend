package com.mrdevv.payload.dto.pregunta;

import com.mrdevv.payload.dto.respuesta.ResponseRespuestasDTO;

import java.util.List;

public record ResponsePreguntasDTO(
        Long id,
        String pregunta,
        List<ResponseRespuestasDTO> respuestas
) {}
