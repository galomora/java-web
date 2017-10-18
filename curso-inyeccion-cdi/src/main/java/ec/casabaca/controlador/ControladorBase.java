package ec.casabaca.controlador;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public abstract class ControladorBase implements Serializable {
	public String getFecha () {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		return format.format(new Date ());
	}
	
	public void adicionarMensajeGlobal (Severity tipo, String cuerpoMensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, cuerpoMensaje, cuerpoMensaje));
    }
	
	public void adicionarMensaje (String idComponente, Severity tipo, String cuerpoMensaje) {
        FacesContext.getCurrentInstance().addMessage(idComponente, new FacesMessage(tipo, cuerpoMensaje, cuerpoMensaje));
    }
	
	public void adicionarMensajeError (String idComponente, String cuerpoMensaje) {
			adicionarMensaje(idComponente, FacesMessage.SEVERITY_ERROR , cuerpoMensaje);
			adicionarMensajeGlobal (FacesMessage.SEVERITY_ERROR , cuerpoMensaje);
    }
	
	public void adicionarMensajeError (String cuerpoMensaje) {
		adicionarMensajeGlobal (FacesMessage.SEVERITY_ERROR , cuerpoMensaje);
	}
	
	public void adicionarMensajeInfo (String idComponente, String cuerpoMensaje) {
			adicionarMensaje(idComponente, FacesMessage.SEVERITY_INFO , cuerpoMensaje);
			adicionarMensajeGlobal (FacesMessage.SEVERITY_ERROR , cuerpoMensaje);
    }
	
	public void adicionarMensajeInfo (String cuerpoMensaje) {
		adicionarMensajeGlobal (FacesMessage.SEVERITY_INFO, cuerpoMensaje);
}
	
}
