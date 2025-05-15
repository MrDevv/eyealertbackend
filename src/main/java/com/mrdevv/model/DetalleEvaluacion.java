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
    @Column(name = "DETALLE_EVALUACION_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "EVALUACION_ID")
    Evaluacion evaluacion;

    @ManyToOne
    @JoinColumn(name = "PREGUNTA_ID")
    Pregunta pregunta;

    @ManyToOne
    @JoinColumn(name = "RESPUESTA_ID")
    Respuesta respuesta;

    @Column(name = "RESPUESTA_TEXTO")
    String respuestaTexto;


}
