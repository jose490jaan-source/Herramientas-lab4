package com.herramientas.repository;

import org.springframework.data.repository.CrudRepository;

import com.herramientas.models.Categoria;

public interface ICategoriaRepository extends CrudRepository<Categoria, Integer> {

}
