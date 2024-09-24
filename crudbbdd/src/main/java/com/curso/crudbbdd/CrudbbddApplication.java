package com.curso.crudbbdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.curso.crudbbdd.model")
@EnableJpaRepositories(basePackages = "com.curso.crudbbdd.repository")
@SpringBootApplication(scanBasePackages = {"com.curso.crudbbdd.controller", "com.curso.crudbbdd.service"})
public class CrudbbddApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudbbddApplication.class, args);
	}

}
