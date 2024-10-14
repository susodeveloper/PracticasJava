package com.agencia.hotel.repositories;

import com.agencia.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepositroy extends JpaRepository<Hotel, Integer> {
    Optional<List<Hotel>> findAllByDisponibleTrue();
    Optional<Hotel> findByNombre(String nombre);
}
