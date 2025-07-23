package br.com.guilherme.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bicicleta
 *
 */
@Entity
public class Bicicleta extends VeiculoPasseio {

	
	private Integer tamanhoAro;

	public Integer getTamanhoAro() {
		return tamanhoAro;
	}

	public void setTamanhoAro(Integer tamanhoAro) {
		this.tamanhoAro = tamanhoAro;
	}
	
	
   
}
