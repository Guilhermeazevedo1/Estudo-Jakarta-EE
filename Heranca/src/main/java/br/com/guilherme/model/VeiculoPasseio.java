package br.com.guilherme.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class VeiculoPasseio extends Veiculo{

	private Integer qtdePessoas;

	public Integer getQtdePessoas() {
		return qtdePessoas;
	}

	public void setQtdePessoas(Integer qtdePessoas) {
		this.qtdePessoas = qtdePessoas;
	}
	
	
   
}
