package br.com.guilherme.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.guilherme.ejb.VeiculoBean;

@Named
@RequestScoped
public class FormBean implements Serializable{
	
	@EJB
	private VeiculoBean veiculoBean;

	public VeiculoBean getVeiculoBean() {
		return veiculoBean;
	}
	
}
