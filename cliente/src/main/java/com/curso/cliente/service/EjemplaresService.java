package com.curso.cliente.service;

import com.curso.cliente.model.Ejemplar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EjemplaresService {
    List<Ejemplar> nuevoEjemplar(Ejemplar ejemplar);
    List<Ejemplar> nuevoEjemplarRestClient(Ejemplar ejemplar);
}
