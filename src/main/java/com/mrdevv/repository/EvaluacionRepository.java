package com.mrdevv.repository;

import com.mrdevv.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {


    public List<Evaluacion> findAllByUsuarioId(Long id);

}
