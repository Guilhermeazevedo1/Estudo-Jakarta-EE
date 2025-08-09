package br.com.guilherme.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.guilherme.model.Aluno;

@Stateless
public class AlunoDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public Aluno salvar(Aluno aluno) {
		if(aluno.getId() == null) {
			em.persist(aluno);
			return aluno;
		}else {
			return em.merge(aluno);
		}
	}
	
	public void excluir(Long id) {
		Aluno aluno = em.find(Aluno.class, id);
		if(aluno != null) {
			em.remove(aluno);
		}
	}
	
	public Aluno buscarPorId(Long id) {
		return em.find(Aluno.class, id);
	}
	
	public List<Aluno> buscarTodos(){
		return em.createQuery("Select a from Aluno a", Aluno.class).getResultList();
	}
	
}
