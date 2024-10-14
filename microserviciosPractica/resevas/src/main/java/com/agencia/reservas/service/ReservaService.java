package com.agencia.reservas.service;

import com.agencia.reservas.model.Reserva;

import java.util.List;

public interface ReservaService {
    Reserva hacerReserva(Integer idVuelo, Integer idHotel, String nombre, String dni, Integer plazas);
    List<Reserva> obtenerReservas(String nombre, String dni, Integer idVuelo);
    List<Reserva> obtenerTodas();
}
