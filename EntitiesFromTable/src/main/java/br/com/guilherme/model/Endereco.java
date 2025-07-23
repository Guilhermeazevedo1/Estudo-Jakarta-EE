package br.com.guilherme.model;

import java.io.Serializable;
import javax.persistence.*;



@Entity
public class Endereco implements Serializable {

	@EmbeddedId
	private EnderecoPK id;

	private String complemento;

	private String numero;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	private Cliente cliente;

	public EnderecoPK getId() {
		return this.id;
	}

	public void setId(EnderecoPK id) {
		this.id = id;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}