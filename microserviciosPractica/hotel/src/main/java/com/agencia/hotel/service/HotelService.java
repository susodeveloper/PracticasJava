package com.agencia.hotel.service;

import com.agencia.hotel.model.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    List<Hotel> getAvailabilityHotels();
    Hotel getHotelByNombre(String nombre);
}
