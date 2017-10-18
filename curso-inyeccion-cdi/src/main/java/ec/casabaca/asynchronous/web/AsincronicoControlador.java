package ec.casabaca.asynchronous.web;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ec.casabaca.asynchronous.ejb.AsincronicoBean;
import ec.casabaca.util.JSFUtil;

@Named
@SessionScoped
public class AsincronicoControlador implements Serializable {

	@EJB
	AsincronicoBean asincronicoBean;
	@Inject
	JSFUtil jsfUtil;
	
	Future<String> resultado = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void invocarAsincronico() {
		
		try {
			resultado = asincronicoBean.ejecucionAsincronica();
			jsfUtil.adicionarMensaje(FacesMessage.SEVERITY_INFO, "INICIA EJECUCION");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void verEstado () {
		try {
			if (resultado.isDone()) {
				jsfUtil.adicionarMensaje(FacesMessage.SEVERITY_INFO, resultado.get());
			} else if (resultado.isCancelled()) {
				jsfUtil.adicionarMensaje(FacesMessage.SEVERITY_WARN, resultado.get());
			} else {
				jsfUtil.adicionarMensaje(FacesMessage.SEVERITY_INFO, "EJECUTANDO");
			}
		} catch (InterruptedException e) {
			jsfUtil.adicionarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR DE INTERRUPCION");
		} catch (ExecutionException e) {
			jsfUtil.adicionarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR DE EJECUCION");
		}
		
	}

	public void cancelarAsincronico () {
		resultado.cancel(Boolean.TRUE);
	}
}
