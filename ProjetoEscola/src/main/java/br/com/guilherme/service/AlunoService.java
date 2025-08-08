package br.com.guilherme.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.guilherme.DAO.AlunoDao;
import br.com.guilherme.model.Aluno;


@Stateless
public class AlunoService {

    @Inject 
    AlunoDao alunoDao;
	
    public Aluno salvarAluno(Aluno aluno) {
    	return alunoDao.salvar(aluno);
    }
	
    public void deletarAluno(Long id) {
    	alunoDao.excluir(id);
    }
    
    public Aluno buscarPorId(Long id) {
    	return alunoDao.buscarPorId(id);
    }
    
    public List<Aluno> buscarTodos(){
    	return alunoDao.buscarTodos();
    }
    
    public AlunoService() {
        // TODO Auto-generated constructor stub
    }

}
