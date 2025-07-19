package br.com.guilherme.bean;

import br.com.guilherme.model.Regiao;
import br.com.guilherme.model.Estado;
import br.com.guilherme.business.RegioesProvider;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@Named
@SessionScoped
public class FormBean {
	
	private Collection<Regiao> regioes;
	private Collection<Estado> estados;
	private String siglaRegiao;
	private String siglaEstado;
	
	@PostConstruct
	public void init() {
		regioes = RegioesProvider.getRegioes(); 
	}
	
	
	public Collection<Regiao> getRegioes(){
		return regioes;
	}
	
	public Collection<Estado> getestados(){
		return estados;
	}

	public Collection<Estado> getEstados() {
		return estados;
	}
	
	public void carregarEstados(ActionEvent event) {
		this.estados = RegioesProvider.getEstadosByRegiao(siglaRegiao);
	}

	public void setEstados(Collection<Estado> estados) {
		this.estados = estados;
	}

	public String getSiglaRegiao() {
		return siglaRegiao;
	}

	public void setSiglaRegiao(String siglaRegiao) {
		this.siglaRegiao = siglaRegiao;
	}

	public String getSiglaEstado() {
		return siglaEstado;
	}

	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}

	public void setRegioes(Collection<Regiao> regioes) {
		this.regioes = regioes;
	}
	
	
	
	
}
