package com.agencia.reservas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vuelo {
    private Integer idVuelo;

    private String compania;

    private LocalDateTime fechaVuelo;

    private double precio;

    private int plazasDisponibles;
}