package com.fiap.control;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}