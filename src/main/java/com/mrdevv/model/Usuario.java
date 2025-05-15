package com.mrdevv.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "mae_usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USUARIO_ID")
    private Long id;

    private String nombres;

    private String apellidos;

    private String email;

    private String password;

    @Column(name = "CUESTIONARIO_CONOCIMIENTOS_COMPLETADO")
    private Boolean cuestionarioCompleado;

    @ManyToOne
    @JoinColumn(name = "ROL_ID")
    private Rol rol;

    @CreationTimestamp
    private LocalDateTime fecha;

}
