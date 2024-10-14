package com.agencia.reservas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaRequest {
    private Integer idVuelo;
    private Integer idHotel;
    private String nombre;
    private String dni;
    private Integer plazas;
}
