package com.fiap.control;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}