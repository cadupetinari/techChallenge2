package com.fiap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "produto")
@Table(name = "produto")
public class Produto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String urlFoto;
    private double preco;
    private int idCategoria;
	
    // Getters
    public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getURLFoto() {
		return urlFoto;
	}
	public double getPreco() {
		return preco;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	
	// Setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setURLFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
}