package com.mrdevv.model;


import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "MAE_USUARIOS")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USUARIO_ID")
    private Long id;

    private String nombres;

    private String apellidos;

    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "ROL_ID")
    private Rol rol;

}
