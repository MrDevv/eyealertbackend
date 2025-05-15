package com.mrdevv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "mae_datos_informativos")
public class DatoInformativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dato_informativo_id")
    private Long id;

    private String titulo;

    private String descripcion;

    private String fuente;

    @Column(name = "fuente_multimedia")
    private String fuenteMultimedia;

}
