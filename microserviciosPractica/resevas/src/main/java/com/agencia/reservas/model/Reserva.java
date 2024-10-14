package com.agencia.reservas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Reserva")
    private Integer idReserva;

   @Column(name = "Nombre_Cliente")
   private String nombreCliente;

   @Column(name = "DNI")
   private String dni;

   @Column(name = "Id_Hotel")
   private Integer idHotel;

   @Column(name = "Id_Vuelo")
   private Integer idVuelo;
}
