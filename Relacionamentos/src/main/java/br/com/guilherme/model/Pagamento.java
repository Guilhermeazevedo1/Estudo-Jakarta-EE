package br.com.guilherme.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Pagamento implements Serializable {

	public enum TipoPagamento {
		CARTAO_CREDITO,
		BOLETO
	}
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pagto", length = 20, nullable = false)
	private TipoPagamento tipoPagto;
	
	@OneToOne(mappedBy = "pagamento")
	private Pedido pedido;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoPagamento getTipoPagto() {
		return tipoPagto;
	}

	public void setTipoPagto(TipoPagamento tipoPagto) {
		this.tipoPagto = tipoPagto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", tipoPagto=" + tipoPagto + "]";
	}
	
	
   
}
