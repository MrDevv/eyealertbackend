package com.mrdevv.repository;

import com.mrdevv.model.PreguntaQuizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaQuizzRepository extends JpaRepository<PreguntaQuizz, Long> {

    @Query(value = "select * from mae_preguntas_quizz where estado = 1 order by rand() limit :limit", nativeQuery = true)
    List<PreguntaQuizz> findAllPreguntas(@Param("limit") Integer limit);

}
