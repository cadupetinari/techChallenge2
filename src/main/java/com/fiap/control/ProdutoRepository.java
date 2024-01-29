package com.fiap.control;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}