package br.com.guilherme.bean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.guilherme.ejb.VooBean;
import br.com.guilherme.model.Voo;

@Named("form")
@RequestScoped
public class FromBean {
	
	@EJB
	private VooBean vooBean;
	
	public String processar() {
		int numero = 1266;
		String empresa = "LATAM";
		
		Voo voo = new Voo();
		voo.setNumero(numero);
		voo.setEmpresa(empresa);
		voo.setOrigem("São Paulo");
		voo.setDestino("Recife");
		
		vooBean.inserir(voo);
		
		Voo vooDB = vooBean.carregar(numero, empresa);
		System.out.println(vooDB);
		
		return null;
	}
}
