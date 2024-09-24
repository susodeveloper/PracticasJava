package com.curso.crudbbdd.service.impl;

import com.curso.crudbbdd.model.Libro;
import com.curso.crudbbdd.service.LibroService;
import com.curso.crudbbdd.repository.LibrosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {
    private final LibrosRepository librosRepository;

    public LibroServiceImpl(LibrosRepository librosRepository) {
        this.librosRepository = librosRepository;
    }


    @Override
    public List<Libro> libros() {
        return this.librosRepository.findAll();
    }

    @Override
    public Libro buscarLibro(int isbn) {
        return this.librosRepository.findById(isbn).orElse(null);
    }

    @Override
    public void altaLibro(Libro libro) {
        this.librosRepository.save(libro);
    }

    @Override
    public void actualizarLibro(Libro libro) {
        this.librosRepository.save(libro);
    }

    @Override
    public List<Libro> eliminarLibros(int isbn) {
        this.librosRepository.deleteById(isbn);
        return this.libros();
    }
}
