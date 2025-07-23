package br.com.guilherme.model;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Carro extends VeiculoPasseio{

	
	private Integer qtdePortas;

	public Integer getQtdePortas() {
		return qtdePortas;
	}

	public void setQtdePortas(Integer qtdePortas) {
		this.qtdePortas = qtdePortas;
	}
   
}
