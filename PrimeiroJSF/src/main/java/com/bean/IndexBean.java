package com.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("bean")
@RequestScoped
public class IndexBean implements Serializable{
	
	public String getMensagem() {
		return "Está é uma mensagem vinda do bean 2";
	}
	
}
