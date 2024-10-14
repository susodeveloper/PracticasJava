package com.agencia.vuelos.service;

import com.agencia.vuelos.model.Vuelo;

import java.util.List;

public interface VueloService {
    List<Vuelo> vuelosDisponibles(Integer numPlazas);
    Vuelo actualizarVuelo(Integer idVuelo, Integer numPlazas);
}
