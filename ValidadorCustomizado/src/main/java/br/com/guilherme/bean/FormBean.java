package br.com.guilherme.bean;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("form")
@RequestScoped
public class FormBean {
	
	private Date dataNascimento;

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
