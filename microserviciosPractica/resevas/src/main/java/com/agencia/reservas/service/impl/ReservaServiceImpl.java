package com.agencia.reservas.service.impl;

import com.agencia.reservas.model.Hotel;
import com.agencia.reservas.model.Reserva;
import com.agencia.reservas.repositories.ReservasRepository;
import com.agencia.reservas.service.HotelService;
import com.agencia.reservas.service.ReservaService;
import com.agencia.reservas.service.VuelosService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {
    private final ReservasRepository reservasRepository;
    private final VuelosService vuelosService;
    private final HotelService hotelService;

    public ReservaServiceImpl(ReservasRepository reservasRepository, VuelosService vuelosService, HotelService hotelService) {
        this.reservasRepository = reservasRepository;
        this.vuelosService = vuelosService;
        this.hotelService = hotelService;
    }


    @Override
    public Reserva hacerReserva(Integer idVuelo, Integer idHotel, String nombre, String dni, Integer plazas) {
        Reserva create = new Reserva();
        create.setDni(dni);
        create.setIdHotel(idHotel);
        create.setIdVuelo(idVuelo);
        create.setNombreCliente(nombre);

        Reserva save = this.reservasRepository.save(create);

        if(save.getIdVuelo() != null ) this.vuelosService.actualizaVuelo(save.getIdVuelo(), plazas);

        return save;
    }

    @Override
    public List<Reserva> obtenerReservas(String nombre, String dni, Integer idVuelo) {
        Hotel hotel = this.hotelService.obtenerHotel(nombre);

        if(hotel == null) throw new RuntimeException("Hotel no encontrado");

        List<Reserva> reservaList = this.reservasRepository.findByIdHotelAndIdVueloAndDni(hotel.getIdHotel(), idVuelo, dni);

        if(reservaList.isEmpty()) return Collections.emptyList();

        return reservaList;
    }

    @Override
    public List<Reserva> obtenerTodas() {
        return this.reservasRepository.findAll();
    }
}
