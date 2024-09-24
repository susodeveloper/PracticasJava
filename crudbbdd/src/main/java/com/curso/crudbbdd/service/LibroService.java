package com.curso.crudbbdd.service;

import com.curso.crudbbdd.model.Libro;

import java.util.List;

public interface LibroService {
    List<Libro> libros();
    Libro buscarLibro(int isbn);
    void altaLibro(Libro libro);
    void actualizarLibro(Libro libro);
    List<Libro> eliminarLibros(int isbn);

}
