package com.agencia.vuelos.controller;

import com.agencia.vuelos.model.Vuelo;
import com.agencia.vuelos.service.VueloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VueloController {
    private VueloService vueloService;

    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @Operation(summary = "Lista de vuelos", description = "Lista de vuelos con plazas disponibles")
    @GetMapping(value = "vuelos/{numPlazas}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Vuelo>> ObtenerVuelos(@Parameter(description = "Num Plazas a reservar")
                                     @PathVariable("numPlazas") Integer numPlazas){

        try {
            List<Vuelo> vuelos = this.vueloService.vuelosDisponibles(numPlazas);
            return ResponseEntity.ok(vuelos);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Aztualiza un Vuelo", description = "Actualiza las plazas disponibles en un vuelo")
    @PutMapping(value = "vuelos/{idVuelo}/{numPlazas}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vuelo> actualizaVuelo(@Parameter(description = "Id de vuelo") @PathVariable("idVuelo")Integer idVuelo,
                                @Parameter(description = "Plazas a reservar")@PathVariable("numPlazas")Integer numPlazas){
        try {
            Vuelo vuelo = this.vueloService.actualizarVuelo(idVuelo, numPlazas);
            return ResponseEntity.ok(vuelo);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }
}
