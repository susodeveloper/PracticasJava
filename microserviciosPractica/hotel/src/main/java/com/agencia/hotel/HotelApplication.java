package com.agencia.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.agencia.hotel.model")
@EnableJpaRepositories(basePackages = "com.agencia.hotel.repositories")
@SpringBootApplication(scanBasePackages = { "com.agencia.hotel.controller", "com.agencia.hotel.service" } )
public class HotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}

}
