package br.com.guilherme.validador;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dateValidador")
public class DateValidador implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		Date dateNasc = (Date) value;
		
		Date now = new Date();
		
		if(dateNasc.after(now)) {
			FacesMessage msg = new FacesMessage("A data digitada é maior que a data atual");
			throw new ValidatorException(msg);
		}
		
		if(dateNasc == null) {
			FacesMessage msg = new FacesMessage("Insira uma data no campo");
			throw new ValidatorException(msg);
		}
	}

}
