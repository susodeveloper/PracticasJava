package com.agencia.hotel.service.impl;

import com.agencia.hotel.model.Hotel;
import com.agencia.hotel.repositories.HotelRepositroy;
import com.agencia.hotel.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {
    private HotelRepositroy hotelRepositroy;

    public HotelServiceImpl(HotelRepositroy hotelRepositroy) {
        this.hotelRepositroy = hotelRepositroy;
    }

    @Override
    public List<Hotel> getAvailabilityHotels() {
        return this.hotelRepositroy.findAllByDisponibleTrue().orElse(Collections.emptyList());
    }

    @Override
    public Hotel getHotelByNombre(String nombre) {
        return this.hotelRepositroy.findByNombre(nombre).orElse(null);
    }
}
