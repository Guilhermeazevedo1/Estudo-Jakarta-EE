package br.com.guilherme.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
public class Modulo implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	private Integer posicao;
	
	@ManyToOne
	private Curso curso;
	
	@OneToMany(mappedBy = "modulo")
	private List<Aula> aulas;
	
	public Modulo(String nome, Integer posicao, Curso curso) {
		this.nome = nome;
		this.posicao = posicao;
		this.curso = curso;
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

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}
	
	
	
}
