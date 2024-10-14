package com.agencia.reservas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetails() throws Exception {
        final List<UserDetails> users = List.of(
                User.withUsername("user3")
                        .password("{noop}password3")
                        .roles("ADMIN")
                        .build()
        );

        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "reserva/{nombre}/{dni}/{vuelo}").hasRole("ADMIN")
                .anyRequest().permitAll())
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

}
