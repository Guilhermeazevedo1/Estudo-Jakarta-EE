package br.com.guilherme.bean;

import java.util.ArrayList;
import java.util.List;

//import javax.enterprise.context.ApplicationScoped;
//import javax.enterprise.context.Conversation;
//import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
//import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("lista")
@RequestScoped
public class ListBean {
	private String item;
	
	private List<String> itens = new ArrayList<>();
	
	//para o ConversationScoped do CDI
	@Inject
	//private Conversation conversation;
	
	public String adicionar() {
		if(itens.size() == 0) {
			//conversation.begin();
		}
		
		itens.add(item);
		item = null;
		
		return null;
	}
	
	public String removerTudo() {
		if(itens.size() > 0) {
			itens.clear();
			//conversation.end();
		}
		
		return null;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public List<String> getItens() {
		return itens;
	}

	public void setItens(List<String> itens) {
		this.itens = itens;
	}
	
	
}
