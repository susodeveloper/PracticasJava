package com.curso.crudbbdd.repository;

import com.curso.crudbbdd.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrosRepository extends JpaRepository<Libro, Integer> {
}
