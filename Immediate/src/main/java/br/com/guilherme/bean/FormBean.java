package br.com.guilherme.bean;

import br.com.guilherme.model.Regiao;
import br.com.guilherme.model.Estado;
import br.com.guilherme.business.RegioesProvider;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

@Named("formBean")
@SessionScoped
public class FormBean {
	
	private Collection<Regiao> regioes;
	private Collection<Estado> estados;
	private String siglaRegiao;
	private String siglaEstado;
	private String cidade;
	
	@Inject
	private FacesContext context;
	
	@PostConstruct
	public void init() {
		regioes = RegioesProvider.getRegioes(); 
	}
	
	public void carregarEstados(ValueChangeEvent event) {
		this.estados = RegioesProvider.getEstadosByRegiao(event.getNewValue().toString());
		// pode ser feito assim ou colocando o facesContext como atribruto
		//FacesContext context = FacesContext.getCurrentInstance();
		context.renderResponse();
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	
	
	
}
