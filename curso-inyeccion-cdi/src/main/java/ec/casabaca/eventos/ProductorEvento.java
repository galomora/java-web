package ec.casabaca.eventos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import ec.casabaca.interceptor.LoggingInterceptorBinding;

@Stateless
@LocalBean
public class ProductorEvento {
	@Inject @Default Event<PrintEvent> evento;
	@Inject @BindIt Event<PrintEvent> eventoBind;
	
	@LoggingInterceptorBinding
	public void dispararEvento (int numeroHojas) {
		PrintEvent eventoPrint = new PrintEvent();
		eventoPrint.setNumeroHojas(numeroHojas);
		if (numeroHojas < 10) {
			evento.fire(eventoPrint);
		} else {
			eventoBind.fire(eventoPrint);
		}
	}
	
}
