package com.mrdevv.payload.mapper;

import com.mrdevv.model.Evaluacion;
import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.evaluacion.CreateEvaluationDTO;
import com.mrdevv.payload.dto.evaluacion.ResponseEvaluacionSimpleDTO;
import com.mrdevv.payload.dto.evaluacion.ResponseEvaluacionesByUserDTO;

import java.util.List;

public class EvaluacionMapper {

    public static ResponseEvaluacionSimpleDTO toEvaluacionDTO(Evaluacion evaluacion){
        String resultado = evaluacion.getResultado() == 0 ? "bajo" : "alto";

        return new ResponseEvaluacionSimpleDTO(
                evaluacion.getId(),
                evaluacion.getFecha(),
                evaluacion.getTiempoPrediccion(),
                resultado
        );
    }

    public static ResponseEvaluacionesByUserDTO toEvaluacionByUserDTO(List<Evaluacion> evaluacions) {

        if (evaluacions.isEmpty()) {
            return null;
        }

        Long idUsuario = evaluacions.get(0).getUsuario().getId();
        String nombre = evaluacions.get(0).getUsuario().getNombres();
        String apellidos = evaluacions.get(0).getUsuario().getApellidos();

        List<ResponseEvaluacionSimpleDTO> evaluacionSimpleDTO = evaluacions.stream()
                .map(evaluacion -> {
                            return toEvaluacionDTO(evaluacion);
                        }
                ).toList();

        return new ResponseEvaluacionesByUserDTO(
                idUsuario,
                nombre,
                apellidos,
                evaluacionSimpleDTO
        );
    }

    public static Evaluacion toEvaluacionEntity(CreateEvaluationDTO evaluationDTO){
        return Evaluacion.builder()
                .tiempoPrediccionInicio(evaluationDTO.tipoPrediccionInicio())
                .tiempoPrediccionFin(evaluationDTO.tipoPrediccionFin())
                .tiempoPrediccion(evaluationDTO.tiempoPrediccion())
                .resultado(evaluationDTO.resultado())
                .usuario(Usuario.builder().id(evaluationDTO.usuarioId()).build())
                .build();
    }

}
