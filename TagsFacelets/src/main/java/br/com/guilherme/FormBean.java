package br.com.guilherme;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("form")
@RequestScoped
public class FormBean {
	
	private String nome;
	private String senha;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String processar() {
		return "form";
	}
}
