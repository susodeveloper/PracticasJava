package com.agencia.vuelos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.agencia.vuelos.model")
@EnableJpaRepositories(basePackages = "com.agencia.vuelos.repositories")
@SpringBootApplication(scanBasePackages = {"com.agencia.vuelos.controller", "com.agencia.vuelos.service"} )
public class VuelosApplication {

	public static void main(String[] args) {
		SpringApplication.run(VuelosApplication.class, args);
	}

}
