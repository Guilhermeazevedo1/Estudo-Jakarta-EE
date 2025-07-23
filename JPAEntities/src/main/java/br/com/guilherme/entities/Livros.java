package br.com.guilherme.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

@Entity(name = "LIVROS")
public class Livros implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "AUTOR", length = 60, nullable = false)
	private String autor;
	
	@Column(name = "NUM_PAGINAS", length = 60, nullable = false)
	private Integer numPaginas;
	
	private static final long serialVersionUID = 1L;

	public Livros() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}   
	public Integer getNumPaginas() {
		return this.numPaginas;
	}

	public void setNumPaginas(Integer numPaginas) {
		this.numPaginas = numPaginas;
	}
   
}
