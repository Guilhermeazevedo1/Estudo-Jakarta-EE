package br.com.guilherme.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.guilherme.model.Livro;


@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MyBean {

    @PersistenceContext
    private EntityManager em;
    
    @EJB
    private MyBean2 myBean2;
    
    //@TransactionAttribute(TransactionAttributeType.REQUIRED) // cria uma transação no formBean, se tiver qualquer erro ele não atualiza o banco, pois, a transação foi falha e deu roolback para não completar a trasação
    //@TransactionAttribute(TransactionAttributeType.MANDATORY) // obriga a quem ta chamando no caso o FormBean tenha uma trasação para funcionar, como não tem ele não permite executar e atualizar o banco
    //@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED) // esse metodo não tem transação, então a atualização não é feita no banco de dados
    @TransactionAttribute(TransactionAttributeType.REQUIRED) // exclupação no MyBean 2, mas esa transação deu certo 
    public void mA() {
    	Livro l1 = em.find(Livro.class, 1);
    	l1.setNumPaginas(100);
    	
    	// if usado para o Required
    	//if(l1.getNumPaginas() == 100) {
    	//	throw new RuntimeException("Deu erro!");
    	//}
    	
//    	Livro l2 = em.find(Livro.class, 2);
//    	l2.setNumPaginas(100);
    	
    	myBean2.mB(); // chama a trasação do MyBean 2
    }

}
