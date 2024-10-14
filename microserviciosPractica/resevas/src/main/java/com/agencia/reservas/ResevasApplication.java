package com.agencia.reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestClient;

@EntityScan(basePackages = "com.agencia.reservas.model")
@EnableJpaRepositories(basePackages = "com.agencia.reservas.repositories")
@SpringBootApplication(scanBasePackages = {"com.agencia.reservas.controller", "com.agencia.reservas.service", "com.agencia.reservas.config"} )
public class ResevasApplication {

	public static void main(String[] args) {

		SpringApplication.run(ResevasApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestClient.Builder restClientBuilder(){
		return RestClient.builder();
	}

	@Bean
	public RestClient restClient(RestClient.Builder builder){
		return builder.build();
	}
}
