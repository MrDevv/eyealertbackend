package com.mrdevv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "mae_preguntas_quizz")
public class PreguntaQuizz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pregunta_quizz_id")
    Long id;

    String pregunta;

    String categoria;

    Boolean estado;

    @OneToMany(mappedBy = "preguntaQuizz",  fetch = FetchType.LAZY)
    List<RespuestaQuizz> respuestaQuizzes;
}
