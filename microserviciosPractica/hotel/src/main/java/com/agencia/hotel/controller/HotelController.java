package com.agencia.hotel.controller;

import com.agencia.hotel.model.Hotel;
import com.agencia.hotel.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {
    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Operation(summary = "Listado de hoteles", description = "Listado de hoteles disponibles")
    @GetMapping(value = "hoteles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Hotel>> obtenerHoteles(){
        try {
            List<Hotel> hotel = this.hotelService.getAvailabilityHotels();
            return ResponseEntity.ok(hotel);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }

    @Operation(summary = "Información de un hotel", description = "Información de un hotel buscado por nombre")
    @GetMapping(value = "hotel/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hotel> obtenerHotel(@Parameter(description = "Nombre de curso") @PathVariable("nombre") String nombre){
        try {
            Hotel hotelByNombre = this.hotelService.getHotelByNombre(nombre);
            return ResponseEntity.ok(hotelByNombre);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
