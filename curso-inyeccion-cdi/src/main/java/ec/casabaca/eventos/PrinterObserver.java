package ec.casabaca.eventos;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Default;

@Singleton
@Startup
public class PrinterObserver {
	public void onPrint (@Observes @Default PrintEvent evento) {
		System.out.println("imprimiendo " + evento.getNumeroHojas());
	}
	
	public void onPrintAndBind (@Observes @BindIt PrintEvent evento) {
		System.out.println("imprimiendo " + evento.getNumeroHojas() + " agrupando hojas");
	}
}
