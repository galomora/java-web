package ec.casabaca.roster.web.listener;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class PlayerNameChangeListener implements ValueChangeListener {

	public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
		System.out.println("valor anterior " + event.getOldValue());
		System.out.println("valor actual " + event.getNewValue());
		String valorActual = (String) event.getNewValue();
		if (valorActual == null || valorActual.isEmpty()) {
			throw new AbortProcessingException ("Valor nulo no permitido");
		}
	}

}
