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
@Table(name = "MAE_DATOS_INFORMATIVOS")
public class DatoInformativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DATO_INFORMATIVO_ID")
    private Long id;

    private String titulo;

    private String descripcion;

    private String fuente;

    @Column(name = "FUENTE_MULTIMEDIA")
    private String fuenteMultimedia;

}
