package com.curso.cliente.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ejemplar {
    private int isbn;
    private String titulo;
    private String tematica;
}
