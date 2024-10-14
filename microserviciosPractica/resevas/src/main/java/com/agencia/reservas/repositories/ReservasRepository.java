package com.agencia.reservas.repositories;

import com.agencia.reservas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReservasRepository extends JpaRepository<Reserva, Integer> {
    List<Reserva> findByIdHotelAndIdVueloAndDni(Integer idHotel, Integer idVuelo, String dni);
}
