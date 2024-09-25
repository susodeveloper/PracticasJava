package com.curso.cliente.controller;

import com.curso.cliente.model.Ejemplar;
import com.curso.cliente.service.EjemplaresService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EjemplaresController {
    private final EjemplaresService ejemplaresService;

    public EjemplaresController(EjemplaresService ejemplaresService) {
        this.ejemplaresService = ejemplaresService;
    }

    @PostMapping(value="/ejemplar/{isbn}/{titulo}/{tematica}")
    public List<Ejemplar> altaEjemplar(
            @PathVariable("isbn") int isbn,
            @PathVariable("title") String titulo,
            @PathVariable("tematica") String tematica) {

        return this.ejemplaresService.nuevoEjemplar(new Ejemplar(isbn, titulo, tematica));
    }

}
