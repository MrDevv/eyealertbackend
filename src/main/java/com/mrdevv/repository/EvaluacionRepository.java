package com.mrdevv.repository;

import com.mrdevv.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {


    public List<Evaluacion> findAllByUsuarioIdOrderByFechaDesc(Long id);

    public List<Evaluacion> findTop3ByUsuarioIdOrderByFechaDesc(Long id);

    @Query(value = "SELECT * FROM TRS_EVALUACIONES WHERE FECHA >= NOW() - INTERVAL 7 DAY AND USUARIO_ID = :id_usuario ORDER BY FECHA DESC", nativeQuery = true)
    public List<Evaluacion> findLastWeekEvaluationsByUser(@Param("id_usuario") Long id);

    @Query(value = "SELECT * FROM TRS_EVALUACIONES WHERE FECHA >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH) AND USUARIO_ID = :id_usuario ORDER BY FECHA DESC; ", nativeQuery = true)
    public List<Evaluacion> findLastMonthEvaluationByUser(@Param("id_usuario") Long id);
}
