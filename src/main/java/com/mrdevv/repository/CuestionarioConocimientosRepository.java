package com.mrdevv.repository;

import com.mrdevv.model.CuestionarioConocimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CuestionarioConocimientosRepository extends JpaRepository<CuestionarioConocimientos, Long> {

    @Query(value = "SELECT " +
            "SUM(puntaje_obtenido) AS puntaje_total_obtenido, " +
            "COUNT(*) AS numero_participantes, " +
            "15 AS puntaje_total_posible, " +
            "ROUND((SUM(puntaje_obtenido) / (COUNT(*) * 15)) * 100, 2) AS indice_conocimiento " +
            "FROM (" +
            "SELECT puntaje_obtenido " +
            "FROM cuestionario_conocimientos " +
            "LIMIT 30" +
            ") AS primeros_30;", nativeQuery = true)
    Object obtenerIndiceConocimiento();

}
