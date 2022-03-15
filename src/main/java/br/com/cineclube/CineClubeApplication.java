package br.com.cineclube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * Roteiro:
 * Repository (Camada de persistencia)-> JPA + H2
 * 	Fazer caso de uso manter Filme
 * View -> templates html com bootstrap.
 * Controller Filme > com as rotas para manterFilme
 * 
 */
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class CineClubeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CineClubeApplication.class, args);
	}

}
