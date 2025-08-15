package com.mrdevv.repository;

import com.mrdevv.model.Quizz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizzRepository extends JpaRepository<Quizz, Long> {

    @Override
    Page<Quizz> findAll(Pageable pageable);

    @Query(value = "select " +
            "(select max(puntaje) from trs_quizzes where usuario_id = :usuario_id) as puntaje_mas_alto , " +
            "(select puntaje from trs_quizzes where usuario_id = :usuario_id order by fecha desc limit 1) as ultimo_puntaje", nativeQuery = true)
    Object obtenerPuntajeQuizzesUsuario(@Param("usuario_id") Long usuarioId);

    @Query(value = "select " +
            "rank() over(order by q.puntaje desc, q.fecha asc) puesto, " +
            "u.usuario_id, " +
            "u.nombres, " +
            "u.apellidos, " +
            "max(q.puntaje) puntaje " +
            "from trs_quizzes q " +
            "inner join mae_usuarios u on q.usuario_id = u.usuario_id " +
            "where month(q.fecha) = month(current_date) " +
            "and year(q.fecha) = year(current_date) " +
            "group by u.usuario_id " +
            "order by q.puntaje desc, q.fecha asc " +
            "limit 5", nativeQuery = true)
    List<Object> obtenerRankingLimit5();

    @Query(value = "with puntajes as ( " +
            "select " +
            "rank() over(order by q.puntaje desc, q.fecha asc) puesto, " +
            "u.usuario_id, " +
            "u.email, " +
            "u.nombres, " +
            "u.apellidos " +
            "from trs_quizzes q " +
            "inner join mae_usuarios u on q.usuario_id = u.usuario_id " +
            "where month(q.fecha) = month(current_date) " +
            "and year(q.fecha) = year(current_date) " +
            "group by u.usuario_id " +
            "order by q.puntaje desc, q.fecha asc " +
            ") " +
            "select puesto, usuario_id, nombres, apellidos from puntajes where email = :email", nativeQuery = true)
    Object obtenerPuestoActualUsuario(@Param(value = "email") String email);
}
