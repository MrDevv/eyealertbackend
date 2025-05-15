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
    @Column(name = "CUESTIONARIO_CONOCIMIENTOS_ID")
    Long id;

    @CreationTimestamp
    LocalDateTime fecha;

    @OneToOne
    @JoinColumn(name = "USUARIO_ID")
    Usuario usuario;

    @Column(name = "PUNTAJE_OBTENIDO")
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
