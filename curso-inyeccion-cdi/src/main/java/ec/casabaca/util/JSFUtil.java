package ec.casabaca.util;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

@RequestScoped
public class JSFUtil {
	public void adicionarMensaje(Severity tipo, String cuerpoMensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, cuerpoMensaje, cuerpoMensaje));
    }
}
