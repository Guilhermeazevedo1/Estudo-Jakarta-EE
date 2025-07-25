package br.com.guilherme.model;

import java.io.Serializable;
import javax.persistence.*;


public class Endereco implements Serializable {

	
	private String rua;
	private Integer numero;
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	
	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", numero=" + numero + "]";
	}
	
}
