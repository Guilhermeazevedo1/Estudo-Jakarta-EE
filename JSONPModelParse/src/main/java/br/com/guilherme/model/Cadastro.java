package br.com.guilherme.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



public class Cadastro implements Serializable {

	
	private String nome;
	private Integer idade;
	private LocalDate dataNascimento;
	private Boolean casado;
	private Endereco endereco = new Endereco();
	private List<String> interesses = new ArrayList<>();
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Boolean getCasado() {
		return casado;
	}
	public void setCasado(Boolean casado) {
		this.casado = casado;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<String> getInteresses() {
		return interesses;
	}
	public void setInteresses(List<String> interesses) {
		this.interesses = interesses;
	}
	@Override
	public String toString() {
		return "Cadastro [nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", casado="
				+ casado + ", endereco=" + endereco + ", interesses=" + interesses + "]";
	}
   
	
	
}
