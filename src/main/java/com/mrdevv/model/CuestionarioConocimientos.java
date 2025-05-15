package com.mrdevv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cuestionario_conocimientos")
public class CuestionarioConocimientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuestionario_conocimientos_id")
    Long id;

    @CreationTimestamp
    LocalDateTime fecha;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    Usuario usuario;

    @Column(name = "puntaje_obtenido")
    Integer puntajeObtenido;

    public static Integer calcularPuntajeTotal(List<RespuestaCuestionarioConocimientos> respuestaCuestionarioConocimientos){
        AtomicInteger puntajeTotal = new AtomicInteger(0);
        respuestaCuestionarioConocimientos.forEach(respuesta ->{
            if(respuesta.getPuntajePregunta()){
                puntajeTotal.incrementAndGet();
            }
        });
        return puntajeTotal.get();
    }
}
