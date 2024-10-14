package com.agencia.reservas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
    private Integer idHotel;
    private String nombre;
    private String categoria;
    private Double precio;
    private Boolean disponible;
}
