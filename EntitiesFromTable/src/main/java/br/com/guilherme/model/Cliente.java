package br.com.guilherme.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
public class Cliente implements Serializable {

	@Id
	private int id;

	private String nome;

	@Column(name="RECEBER_EMAIL")
	private byte receberEmail;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="cliente")
	private List<Endereco> enderecos;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte getReceberEmail() {
		return this.receberEmail;
	}

	public void setReceberEmail(byte receberEmail) {
		this.receberEmail = receberEmail;
	}

	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco addEndereco(Endereco endereco) {
		getEnderecos().add(endereco);
		endereco.setCliente(this);

		return endereco;
	}

	public Endereco removeEndereco(Endereco endereco) {
		getEnderecos().remove(endereco);
		endereco.setCliente(null);

		return endereco;
	}

}