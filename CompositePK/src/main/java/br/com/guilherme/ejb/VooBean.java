package br.com.guilherme.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.guilherme.model.Voo;
import br.com.guilherme.model.VooPK;


@Stateless
public class VooBean {
	
	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Voo voo) {
		em.persist(voo);
	}
	
	public Voo carregar(Integer numero, String empresa) {
		return em.find(Voo.class, new VooPK(numero, empresa));
	}
}
