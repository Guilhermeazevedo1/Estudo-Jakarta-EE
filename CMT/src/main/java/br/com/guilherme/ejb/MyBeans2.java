package br.com.guilherme.ejb;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.guilherme.model.Livro;

/**
 * Session Bean implementation class MyBeans2
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MyBean2 {

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private EJBContext ejbContext;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)// obriga a criação de uma nova transação, tansação 1 recebeu o commit e a 2 recebeu rollback, por conta do final da função
	public void mB() {
		Livro l2 = em.find(Livro.class, 2);
		l2.setNumPaginas(100);
		ejbContext.setRollbackOnly();
	}
}
