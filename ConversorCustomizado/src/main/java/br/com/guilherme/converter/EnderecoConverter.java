package br.com.guilherme.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.guilherme.model.Endereco;

@FacesConverter(forClass = Endereco.class)
public class EnderecoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent ui, String value) {
		// TODO Auto-generated method stub
		if(value == null) {
			return null;
		}
		
		String[] tokens = value.split(",");
		Endereco endereco = new Endereco();
		endereco.setRua(tokens[0].trim());
		endereco.setNumero(tokens[1].trim());
		return endereco;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent ui, Object value) {
		// TODO Auto-generated method stub
		Endereco endereco = (Endereco) value;
		return endereco.getRua() + ", " + endereco.getNumero();
	}
	
	

}
