package com.agencia.reservas.service.impl;

import com.agencia.reservas.model.Vuelo;
import com.agencia.reservas.service.VuelosService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class VuelosServiceImpl implements VuelosService {
    private final RestClient restClient;
    private final String url = "http://localhost:8082/svuelo/";

    public VuelosServiceImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public Vuelo actualizaVuelo(Integer idVuelo, Integer numPlazas) {
        return this.restClient.put().uri(url + "vuelos/" + idVuelo +"/" + numPlazas)
                .retrieve().body(Vuelo.class);
    }
}
