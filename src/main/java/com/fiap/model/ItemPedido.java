package com.fiap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "item_pedido")
@Table(name = "item_pedido")
public class ItemPedido {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idPedido;
	private Long idProduto;
	private int quantidade;
	
	// Getters
	public Long getId() {
		return id;
	}
	public Long getIdPedido() {
		return idPedido;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	
	// Setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}