package com.fiap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "categoria")
@Table(name = "categoria")
public class Categoria {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoria;
    
    // Getters
	public Long getId() {
		return id;
	}
	public String getCategoria() {
		return categoria;
	}
	
	// Setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	} 
}