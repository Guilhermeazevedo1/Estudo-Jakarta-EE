package br.com.guilherme.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.guilherme.ejb.ItensBean;

@Named("form")
@RequestScoped
public class FormBean {
	
	@EJB
	private ItensBean itensBean;
	
	public List<String> getItens(){
		return itensBean.getItens();
	}
}
