package com.mrdevv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.time.LocalDateTime;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trs_evaluaciones")
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluacion_id")
    private Long id;

    @CreationTimestamp
    private LocalDateTime fecha;

    @Column(name = "tiempo_prediccion_inicio")
    private LocalDateTime tiempoPrediccionInicio;

    @Column(name = "tiempo_prediccion_fin")
    private LocalDateTime tiempoPrediccionFin;

    private Double tiempoPrediccion;

    private Integer resultado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
