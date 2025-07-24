package br.com.guilherme.bean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.guilherme.ejb.MyBean;

@Named
@RequestScoped
public class FormBean {
	
	@EJB
	private MyBean myBean;
	
	public String executar() throws Exception {
		myBean.mA();
		return null;
	}
}
