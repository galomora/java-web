package ec.casabaca.roster.web.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator ("ec.casabaca.PlayerNameValidator")
public class PlayerNameValidator implements Validator {

	public void validate(FacesContext context, UIComponent component, Object valor) throws ValidatorException {
		if (valor == null) {
			throw new ValidatorException (
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "El nombre no puede ser nulo", "El nombre no puede ser nulo"));
		}
		String valorString = (String) valor;
		String[] palabras = valorString.split(" ");
		if (palabras.length < 2) {
			throw new ValidatorException (
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Es requerido por lo menos un nombre y un apellido", "Es requerido por lo menos un nombre y un apellido"));
		}
	}

}
