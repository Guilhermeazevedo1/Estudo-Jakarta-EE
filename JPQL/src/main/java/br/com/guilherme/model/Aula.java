package br.com.guilherme.model;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Aula implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	private Integer duracao;
	
	private Integer posicao;
	
	@ManyToOne
	private Modulo modulo;
	
	public Aula(String nome, Integer duracao, Integer posicao, Modulo modulo) {
		this.nome = nome;
		this.duracao = duracao;
		this.posicao = posicao;
		this.modulo = modulo;
	}
   
	public Aula() {
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

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	
	
}
