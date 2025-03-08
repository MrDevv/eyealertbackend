package com.mrdevv.repository;

import com.mrdevv.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {

    @Query(value = "SELECT " +
            "P.PREGUNTA_ID, " +
            "P.DESCRIPCION 'PREGUNTA', " +
            "GROUP_CONCAT(R.DESCRIPCION ORDER BY R.RESPUESTA_ID SEPARATOR ', ') AS RESPUESTAS " +
            "FROM MAE_PREGUNTAS p " +
            "LEFT JOIN TRS_PREGUNTA_DETALLE pd ON p.PREGUNTA_ID = pd.PREGUNTA_ID " +
            "LEFT JOIN MAE_RESPUESTAS r ON pd.RESPUESTA_ID = r.RESPUESTA_ID " +
            "GROUP BY p.PREGUNTA_ID, P.DESCRIPCION;", nativeQuery = true)
    List<Object[]> getPreguntas();
}
