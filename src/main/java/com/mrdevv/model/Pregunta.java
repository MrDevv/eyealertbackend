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
@Table(name = "MAE_PREGUNTAS")
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PREGUNTA_ID")
    private Long id;
    private String descripcion;
    private Boolean estado;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "TRS_PREGUNTA_DETALLE",
            joinColumns = @JoinColumn(name = "PREGUNTA_ID"),
            inverseJoinColumns = @JoinColumn(name = "RESPUESTA_ID")
    )
    private List<Respuesta> respuestas;
}
