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
@Table(name = "respuesta_cuestionario_conocimientos")
public class RespuestaCuestionarioConocimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "respuesta_cuestionario_conocimientos_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cuestionario_conocimientos_id")
    CuestionarioConocimientos cuestionarioConocimientos;

    private String pregunta;

    private Character respuesta;

    @Column(name = "puntaje_pregunta")
    private Boolean puntajePregunta;

}
