package br.com.guilherme.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import br.com.guilherme.model.Livro;


@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class MyBean {

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private UserTransaction ut;
	
	public void mA() throws Exception {
		
		List<Livro> livros = em.createQuery("SELECT l FROM Livro l ORDER BY l.id", Livro.class).getResultList();
		
		for(Livro livro : livros) {
			ut.begin();
			livro.setTitulo("???");
			em.merge(livro);
			
			if(livro.getId() == 3) {
				ut.rollback();
				continue;
			}
			
			ut.commit();
		}
	}
}
