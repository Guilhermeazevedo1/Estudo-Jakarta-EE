package br.com.guilherme.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBean implements Serializable{
	
	private String nome;
	private String password;
	
	@PostConstruct
	public void onCreat() {
		System.out.println("Bean Criado");
	}
	
	@PreDestroy
	public void onDestroy() {
		System.out.println("Bean destruído");
	}
	
	public String doLogin() {
		if("abc".equals(nome) && "123".equals(password)) {
			return "sucess";
		}
		
		FacesMessage msg = new FacesMessage("Login incorreto");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, msg);
		
		return null;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
