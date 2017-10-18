package ec.casabaca.persona.controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import ec.casabaca.persona.modelo.Persona;
import ec.casabaca.persona.servicio.PersonaServicio;
import ec.casabaca.util.JSFUtil;

@Named
@SessionScoped
public class VerPersonaControlador implements Serializable {

	@EJB PersonaServicio personaServicio;
	@Inject JSFUtil jsfUtil;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Persona persona;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public void guardarPersona () {
		this.personaServicio.actualizarPersona(persona);
		jsfUtil.adicionarMensaje(FacesMessage.SEVERITY_INFO, "Persona guardada");
	}
	
}
