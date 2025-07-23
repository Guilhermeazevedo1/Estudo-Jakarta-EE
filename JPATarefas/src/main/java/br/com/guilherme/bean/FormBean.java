package br.com.guilherme.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.guilherme.ejb.TarefaBean;
import br.com.guilherme.model.Tarefa;

@Named("form")
@RequestScoped
public class FormBean implements Serializable{
	
	@EJB
	private TarefaBean tarefaBean;
	
	@Inject
	private FacesContext context;
	
	private UIComponent searchInputText;
	
	private Integer tarefaID;
	
	private Tarefa tarefa;
	
	public void gravar(AjaxBehaviorEvent event) {
		if(tarefa.getId() == null) {
			tarefaBean.inserir(tarefa);
		}else {
			tarefaBean.atualizar(tarefa);
		}
		
		tarefa = null;
	}
	
	public void pesquisar(AjaxBehaviorEvent event) {
		tarefa = tarefaBean.carregar(tarefaID);
		
		if(tarefa == null) {
			context.addMessage(searchInputText.getClientId(context), new FacesMessage("Tarefa não encontrada"));
		}
		
		tarefa = null;
	}
	
	public void excluir(AjaxBehaviorEvent event) {
		tarefaBean.excluir(tarefa);
		tarefa = null;
	}
	
	public Tarefa getTarefa() {
		if(tarefa == null) {
			tarefa = new Tarefa();
		}
		
		return tarefa;
	}

	public UIComponent getSearchInputText() {
		return searchInputText;
	}

	public void setSearchInputText(UIComponent searchInputText) {
		this.searchInputText = searchInputText;
	}

	public Integer getTarefaID() {
		return tarefaID;
	}

	public void setTarefaID(Integer tarefaID) {
		this.tarefaID = tarefaID;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	
}
