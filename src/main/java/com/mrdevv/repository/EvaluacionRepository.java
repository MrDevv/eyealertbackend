package com.mrdevv.repository;

import com.mrdevv.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {


    public List<Evaluacion> findAllByUsuarioIdOrderByFechaDesc(Long id);

    public List<Evaluacion> findTop3ByUsuarioIdOrderByFechaDesc(Long id);

    @Query(value = "SELECT * FROM trs_evaluaciones WHERE fecha >= NOW() - INTERVAL 7 DAY AND usuario_id = :id_usuario ORDER BY fecha DESC", nativeQuery = true)
    public List<Evaluacion> findLastWeekEvaluationsByUser(@Param("id_usuario") Long id);

    @Query(value = "SELECT * FROM trs_evaluaciones WHERE fecha >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH) AND usuario_id = :id_usuario ORDER BY fecha DESC; ", nativeQuery = true)
    public List<Evaluacion> findLastMonthEvaluationByUser(@Param("id_usuario") Long id);

    @Modifying
    @Query(value = "UPDATE trs_evaluaciones SET resultado_acertado = :resultado WHERE evaluacion_id = :evaluacion_id", nativeQuery = true)
    public void updateResultadoEspecialista(@Param("evaluacion_id") Long id, @Param("resultado") Boolean resultado);

    @Query(value = "SELECT " +
            "COUNT(*) AS total_evaluaciones, " +
            "SUM(CASE WHEN resultado_acertado = 1 THEN 1 ELSE 0 END) AS evaluaciones_acertadas, " +
            "SUM(CASE WHEN resultado_acertado = 0 THEN 1 ELSE 0 END) AS evaluaciones_no_acertadas, " +
            "SUM(CASE WHEN resultado_acertado IS NULL THEN 1 ELSE 0 END) AS evaluaciones_pendiente_revision, " +
            "ROUND( " +
            "(SUM(CASE WHEN resultado_acertado = 1 THEN 1 ELSE 0 END) / NULLIF(COUNT(*), 0)) * 100, " +
            "2 " +
            ") AS tasa_acierto " +
            "FROM trs_evaluaciones " +
            "WHERE usuario_id = 1;", nativeQuery = true)
    Object obtenerTasaAciertos();

    @Query(value = "SELECT " +
            "COUNT(*) AS total_evaluaciones, " +
            "ROUND(SUM(tiempo_prediccion) / NULLIF(COUNT(*), 0), 2) AS tiempo_promedio_prediccion " +
            "FROM trs_evaluaciones WHERE usuario_id = 1", nativeQuery = true)
    Object obtenerTiempoPromedio();
}
