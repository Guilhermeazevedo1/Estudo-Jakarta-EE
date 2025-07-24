package br.com.guilherme.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Curso implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	@OneToMany(mappedBy = "curso")
	private List<Modulo> modulos;
   
	public Curso(String nome) {
		this.nome= nome;
	}
	
	public Curso() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}
	
	
}
