package br.com.guilherme.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // uma tabela para todas as classes as informações ficam null se não tiver a informação na classe
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // repete as informações nas tabelas que extederam
@Inheritance(strategy = InheritanceType.JOINED)// cria uma tabela para todas as classes tanto as sub classes e as super classes
public class Veiculo implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String fabricante;
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

   
}
