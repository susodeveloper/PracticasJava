package com.agencia.vuelos.service.impl;

import com.agencia.vuelos.model.Vuelo;
import com.agencia.vuelos.repositories.VueloRepository;
import com.agencia.vuelos.service.VueloService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class VueloServiceImpl implements VueloService {
    private final VueloRepository vueloRepository;

    public VueloServiceImpl(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @Override
    public List<Vuelo> vuelosDisponibles(Integer numPlazas) {
        return this.vueloRepository.findAllByPlazasDisponiblesGreaterThanEqual(numPlazas).orElse(Collections.emptyList());
    }

    @Override
    public Vuelo actualizarVuelo(Integer idVuelo, Integer numPlazas) {
        Optional<Vuelo> VueloBuscado = this.vueloRepository.findById(idVuelo);
        if(!VueloBuscado.isPresent()){
            return null;
        }

        Vuelo vuelo = VueloBuscado.get();
        vuelo.setPlazasDisponibles(vuelo.getPlazasDisponibles() - numPlazas);

        return this.vueloRepository.save(vuelo);
    }
}
