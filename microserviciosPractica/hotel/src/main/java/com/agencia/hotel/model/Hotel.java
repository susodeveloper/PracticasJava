package com.agencia.hotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hoteles")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Hotel")
    private Integer idHotel;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Categoria")
    private String categoria;

    @Column(name="Precio")
    private Double precio;

    @Column(name = "Disponible")
    private Boolean disponible;

}
