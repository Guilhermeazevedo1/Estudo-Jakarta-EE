package br.com.guilherme.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.guilherme.model.Endereco;

@Named("form")
@RequestScoped
public class FormBean {
	
	private Endereco endereco;
	
	public FormBean() {
		endereco = new Endereco();
		endereco.setRua("Rua x");
		endereco.setNumero("50");
	}
	
	public String processar() {
		System.out.println("Rua: " + endereco.getRua());
		System.out.println("Número: " + endereco.getNumero());
		return "result";
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
