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
@Table(name = "TRS_EVALUACIONES")
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVALUACION_ID")
    private Long id;

    @CreationTimestamp
    private LocalDateTime fecha;

    private Double tiempoPrediccion;

    private Integer resultado;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID")
    private Usuario usuario;
}
