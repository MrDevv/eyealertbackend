package com.mrdevv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "trs_quizzes")
public class Quizz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quizz_id")
    Integer quizzId;

    Integer puntaje;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    Usuario usuario;

    @CreationTimestamp
    LocalDateTime fecha;
}
