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
    @Column(name = "RESPUESTA_CUESTIONARIO_CONOCIMIENTOS_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CUESTIONARIO_CONOCIMIENTOS_ID")
    CuestionarioConocimientos cuestionarioConocimientos;

    private String pregunta;

    private Character respuesta;

    @Column(name = "PUNTAJE_PREGUNTA")
    private Boolean puntajePregunta;

}
