package com.fiap.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "pedido")
@Table(name = "pedido")
public class Pedido {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int cpf;
    private double valorTotal;
    private int ordemFila;
    private Date dataCriacao;
    private String status;
    private String statusPagamento;
    
    // Getters
	public Long getId() {
		return id;
	}
	public int getCpf() {
		return cpf;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public int getOrdemFila() {
		return ordemFila;
	}
	public String getStatus() {
		return status;
	}
	public String getStatusPagamento() {
		return statusPagamento;
	}
	
	// Setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public void setOrdemFila(int ordemFila) {
		this.ordemFila = ordemFila;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
}