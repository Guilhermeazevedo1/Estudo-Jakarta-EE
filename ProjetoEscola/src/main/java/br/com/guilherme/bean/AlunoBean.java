package br.com.guilherme.bean;


import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.guilherme.model.Aluno;
import br.com.guilherme.service.AlunoService;

@Named
@RequestScoped
public class AlunoBean {
	
	Aluno aluno = new Aluno();
	
	@EJB
	private AlunoService service;
	
	public String salvar() {
		service.salvarAluno(aluno);
		return "lista?faces-redirect=true";
	}
	
	public String excluir(Long id) {
		service.deletarAluno(id);
		return "lista?faces-redirect=true";
	}
	
	public void buscarPorId(Long id) {
		this.aluno = service.buscarPorId(id);
	}
	
	public List<Aluno> buscarTodos(){
		return service.buscarTodos();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
}
