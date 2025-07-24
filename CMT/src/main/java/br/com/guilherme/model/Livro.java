package br.com.guilherme.model;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Livro implements Serializable {

	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String titulo;
	
	@Column(name = "num_paginas")
	private Integer numPaginas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(Integer numPaginas) {
		this.numPaginas = numPaginas;
	}
	
	
   
}
