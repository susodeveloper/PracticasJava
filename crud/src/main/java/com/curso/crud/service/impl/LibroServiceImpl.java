package com.curso.crud.service.impl;

import com.curso.crud.model.Libro;
import com.curso.crud.service.LibroService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {
    List<Libro> libros;

    public LibroServiceImpl() {
        libros = new ArrayList<>();
        libros.add(new Libro(1111, "Java 15", "Programacion"));
        libros.add(new Libro(2222, "CSS", "Web"));
        libros.add(new Libro(3333, "Python", "Programacion"));
        libros.add(new Libro(4444, "Windows 11", "Sistemas"));
        libros.add(new Libro(5555, "Linux", "Sistemas"));

    }

    @Override
    public List<Libro> libros() {
        return libros;
    }

    @Override
    public Libro buscarLibro(int isbn) {
        return libros.stream()
                .filter(l -> l.getIsbn() == isbn)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void altaLibro(Libro libro) {
        libros.add(libro);
    }

    @Override
    public void actualizarLibro(Libro libro) {
        Libro l = this.buscarLibro(libro.getIsbn());
        if(l != null) {
            l.setTematica(libro.getTematica());
            l.setTitulo(libro.getTitulo());
        }
    }

    @Override
    public List<Libro> eliminarLibros(int isbn) {
        libros.removeIf(l->l.getIsbn() == isbn);
        return libros;
    }
}
