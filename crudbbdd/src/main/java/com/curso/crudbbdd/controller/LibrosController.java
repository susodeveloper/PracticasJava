package com.curso.crudbbdd.controller;

import com.curso.crudbbdd.model.Libro;
import com.curso.crudbbdd.service.LibroService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibrosController {
    private final LibroService librosService;

    public LibrosController(LibroService librosService) {
        this.librosService = librosService;
    }

    @GetMapping(value = "libro/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Libro buscarLibro(@PathVariable("isbn") int isbn) {
        return this.librosService.buscarLibro(isbn);
    }

    @GetMapping(value = "libros", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Libro> buscarLibro() {
        return this.librosService.libros();
    }

    @PostMapping(value = "libro", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void agregarLibro(@RequestBody Libro libro) {
        this.librosService.altaLibro(libro);
    }

    @PutMapping(value = "libro", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarLibro(@RequestBody Libro libro) {
        this.librosService.actualizarLibro(libro);
    }

    @DeleteMapping(value = "libro/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Libro> eliminar(@PathVariable("isbn") int isbn) {
        return this.librosService.eliminarLibros(isbn);
    }

}
