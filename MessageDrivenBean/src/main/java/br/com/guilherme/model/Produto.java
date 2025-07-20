package br.com.guilherme.model;

import java.io.Serializable;

public class Produto implements Serializable{
	
	private int id;
	private String nome;
	
	public Produto(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return id + " => " + nome;
	}
	
	
}
