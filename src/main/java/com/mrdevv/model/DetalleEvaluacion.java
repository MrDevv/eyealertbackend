package com.mrdevv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "trd_detalle_evaluacion")
public class DetalleEvaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_evaluacion_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evaluacion_id")
    Evaluacion evaluacion;

    @ManyToOne
    @JoinColumn(name = "pregunta_id")
    Pregunta pregunta;

    @ManyToOne
    @JoinColumn(name = "respuesta_id")
    Respuesta respuesta;

    @Column(name = "respuesta_texto")
    String respuestaTexto;


}
