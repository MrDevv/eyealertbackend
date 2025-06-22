package com.mrdevv;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

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

//	@Bean
//	CommandLineRunner createPasswordCommand(PasswordEncoder passwordEncoder){
//		return args -> {
//			System.out.println(passwordEncoder.encode("admin"));
//			System.out.println(passwordEncoder.encode("1234"));
//		};
//	}
}
