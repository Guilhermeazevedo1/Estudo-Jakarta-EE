package br.com.guilherme.ejb;

import java.util.Arrays;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;


@Singleton
@Startup // cria o bean no momento da inicialização da aplicação
public class ItensBean {

    private List<String> itens;
    
    @PostConstrutc
    public void setUp() {
    	itens = Arrays.asList("Feijão", "Macarrão", "Alface");
    	System.out.println("Itens inicializados");
    }
    
    public List<String> getItens(){
    	return itens;
    }
}
