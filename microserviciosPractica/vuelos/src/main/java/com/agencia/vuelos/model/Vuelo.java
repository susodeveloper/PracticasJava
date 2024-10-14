package com.agencia.vuelos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vuelos")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_Vuelo")
    private Integer idVuelo;

    @Column(name="Compania")
    private String compania;

    @Column(name="Fecha_Vuelo")
    private LocalDateTime fechaVuelo;

    @Column(name="Precio")
    private double precio;

    @Column(name="Plazas_Disponibles")
    private int plazasDisponibles;
}
