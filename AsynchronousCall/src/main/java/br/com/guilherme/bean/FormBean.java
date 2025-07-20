package br.com.guilherme.bean;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.guilherme.ejb.AsyncBean;

@Named("form")
@SessionScoped
public class FormBean implements Serializable{
	
	@EJB
	private AsyncBean itensBean;
	
	private String mensagem;
	
	private Future<Integer> future;
	
	public String executar() {
		itensBean.processar();
		mensagem = "Processamento Iniciado";
		return null;
	}
	
	public String executarERetornar() {
		future = itensBean.processarERetornar();
		mensagem = "Processamento Iniciado";
		return null;
	}
	
	public String verificar() throws InterruptedException, ExecutionException {
		if(!future.isDone()) {
			mensagem = "Execução em andamento";
		}else {
			mensagem = "Resultado: " + future.get();
		}
		return null;
	}
	
	public String getMensagem() {
		return mensagem;
	}
}
