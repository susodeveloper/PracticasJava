package com.agencia.reservas.controller;

import com.agencia.reservas.model.Reserva;
import com.agencia.reservas.model.ReservaRequest;
import com.agencia.reservas.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservaController {
    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @Operation(summary = "Reserva", description = "Hacer reserva")
    @PostMapping(value = "reservar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reserva> hacerReserva(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos de la reserva", required = true)
                                    @RequestBody ReservaRequest request){
        try {
            Reserva reserva = this.reservaService.hacerReserva(request.getIdVuelo(), request.getIdHotel(), request.getNombre(), request.getDni(), request.getPlazas());
            return ResponseEntity.ok(reserva);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }

    @Operation(summary = "Obtener reservas por hotel y vuelo", description = "Lisstado de reservas  por hotel y vuelo")
    @GetMapping(value = "reserva/{nombre}/{dni}/{vuelo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Reserva>> obtenerReservas(@Parameter(name = "nombre Hotel") @PathVariable("nombre") String nombre,
                                                         @Parameter(name = "dni") @PathVariable("dni") String dni,
                                                         @Parameter(name = "codigo de vuelo") @PathVariable("vuelo") Integer idVuelo){
        try {
            List<Reserva> reservaList = this.reservaService.obtenerReservas(nombre, dni, idVuelo);
            return ResponseEntity.ok(reservaList);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Obtener reservas", description = "Lisstado de todas las reservas")
    @GetMapping(value = "reserva/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Reserva>> obtenerTodasReservas(){
        try {
            List<Reserva> reservaList = this.reservaService.obtenerTodas();
            return ResponseEntity.ok(reservaList);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
