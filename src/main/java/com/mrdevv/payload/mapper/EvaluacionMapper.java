package com.mrdevv.payload.mapper;

import com.mrdevv.model.Evaluacion;
import com.mrdevv.model.Usuario;
import com.mrdevv.payload.dto.evaluacion.*;

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

    public static ResponseTasaAciertoDTO toResponseTasaAciertoDTO(Object responseDatosTasaAcierto){
        Object[] datosTasaAcierto = (Object[]) responseDatosTasaAcierto;

        Integer totalEvaluaciones = ((Number) datosTasaAcierto[0]).intValue();

        if (totalEvaluaciones != 0){
            Integer evaluacionesAcertadas = ((Number) datosTasaAcierto[1]).intValue();
            Integer evaluacionesNoAcertadas = ((Number) datosTasaAcierto[2]).intValue();
            Integer evaluacionesPendienteRevision = ((Number) datosTasaAcierto[3]).intValue();
            Double tasaAcierto = ((Number) datosTasaAcierto[4]).doubleValue();

            return new ResponseTasaAciertoDTO(totalEvaluaciones, evaluacionesAcertadas, evaluacionesNoAcertadas, evaluacionesPendienteRevision, tasaAcierto);
        }

        return new ResponseTasaAciertoDTO(totalEvaluaciones, 0, 0, 0, 0.0);
    }

    public static ResponseTiempoPromedioDTO toResponseTiempoPromedio(Object responseDatosTiempoPromedio){
        Object[] datosTiempoPromedio = ((Object[]) responseDatosTiempoPromedio);

        Integer totalEvaluaciones = ((Number) datosTiempoPromedio[0]).intValue();

        if (totalEvaluaciones != 0){
            Double tiempoPromedio = ((Number) datosTiempoPromedio[1]).doubleValue();

            return new ResponseTiempoPromedioDTO(totalEvaluaciones, tiempoPromedio);
        }

        return new ResponseTiempoPromedioDTO(totalEvaluaciones, 0.0);
    }

}
