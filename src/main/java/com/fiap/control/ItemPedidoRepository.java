package com.fiap.control;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fiap.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

	//Login ADM
		@Query("SELECT p FROM item_pedido p WHERE p.idPedido = :idPedido")
	    List<ItemPedido> existsByIdPedido(@Param("idPedido") Long idPedido);
}