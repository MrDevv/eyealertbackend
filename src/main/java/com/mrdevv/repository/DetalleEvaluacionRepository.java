package com.mrdevv.repository;

import com.mrdevv.model.DetalleEvaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleEvaluacionRepository extends JpaRepository<DetalleEvaluacion, Long> {

    @Query(value = "SELECT " +
            "de.detalle_evaluacion_id, " +
            "e.evaluacion_id, " +
            "e.fecha, " +
            "e.tiempo_prediccion, " +
            "e.resultado, " +
            "u.nombres, " +
            "u.apellidos, " +
            "p.descripcion 'pregunta', " +
            "r.descripcion 'respuesta', " +
            "de.respuesta_texto " +
            "FROM TRD_DETALLE_EVALUACION de " +
            "INNER JOIN TRS_EVALUACIONES e ON de.evaluacion_id = e.evaluacion_id " +
            "INNER JOIN MAE_PREGUNTAS p ON de.pregunta_id = p.pregunta_id " +
            "LEFT JOIN MAE_RESPUESTAS r ON de.respuesta_id = r.respuesta_id " +
            "INNER JOIN MAE_USUARIOS u ON e.usuario_id = u.usuario_id WHERE e.evaluacion_id = :evaluacion_id", nativeQuery = true)
    List<Object[]> findDetalleEvaluacion(@Param("evaluacion_id") Long evaluacionId);
}
