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
@Table(name = "mae_preguntas")
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pregunta_id")
    private Long id;
    private String descripcion;
    private Boolean estado;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "trs_pregunta_detalle",
            joinColumns = @JoinColumn(name = "pregunta_id"),
            inverseJoinColumns = @JoinColumn(name = "respuesta_id")
    )
    private List<Respuesta> respuestas;
}
