package com.mrdevv;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.ZoneId;

@SpringBootApplication
public class EyealertbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EyealertbackendApplication.class, args);
	}

	@PostConstruct
	public void verificarZonaHoraria() {
		System.out.println("Hora local en el backend: " +
				LocalDateTime.now(ZoneId.systemDefault()));
		System.out.println("Zona horaria de JVM: " +
				ZoneId.systemDefault());
	}
}
