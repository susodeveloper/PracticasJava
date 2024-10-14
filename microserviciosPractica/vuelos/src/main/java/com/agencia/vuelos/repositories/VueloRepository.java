package com.agencia.vuelos.repositories;

import com.agencia.vuelos.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
    Optional<List<Vuelo>> findAllByPlazasDisponiblesGreaterThanEqual(Integer plazas);
}
