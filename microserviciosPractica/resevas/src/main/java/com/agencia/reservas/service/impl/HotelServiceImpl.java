package com.agencia.reservas.service.impl;

import com.agencia.reservas.model.Hotel;
import com.agencia.reservas.service.HotelService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class HotelServiceImpl implements HotelService {
    private final RestClient restClient;
    private final String url = "http://localhost:8081/shotel/";

    public HotelServiceImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public Hotel obtenerHotel(String nombre) {
        return this.restClient.get().uri(url+"hotel/"+nombre).retrieve().body(Hotel.class);
    }
}
