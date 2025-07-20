package br.com.guilherme.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Init;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.guilherme.ejb.TemperatureConverter;
import br.com.guilherme.ejb.TemperatureConverterBean;

@Named("form")
@RequestScoped
public class FormBean implements Serializable{
	
	private Double tc;
	private Double tf;
	
	@EJB
	private TemperatureConverterBean converter; // usando diretamente pelo bean
	//private TemperatureConverter converter; usando pela interface
	
	public String convertCelsiusToFahrenheit() {
		this.tf = converter.convertCelsiusToFahrenheit(tc);
		return null;
	}
	
	@Init
	public Double getTc() {
		return tc;
	}

	public void setTc(Double tc) {
		this.tc = tc;
	}

	public Double getTf() {
		return tf;
	}

	public void setTf(Double tf) {
		this.tf = tf;
	}
	
	
	
}
