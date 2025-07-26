package com.mrdevv.repository;

import com.mrdevv.model.Quizz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizzRepository extends JpaRepository<Quizz, Long> {

    @Override
    Page<Quizz> findAll(Pageable pageable);

    @Query(value = "select " +
            "(select max(puntaje) from trs_quizzes where usuario_id = :usuario_id) as puntaje_mas_alto , " +
            "(select puntaje from trs_quizzes where usuario_id = :usuario_id order by fecha desc limit 1) as ultimo_puntaje", nativeQuery = true)
    Object obtenerPuntajeQuizzesUsuario(@Param("usuario_id") Long usuarioId);


}
