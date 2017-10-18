package ec.casabaca.persona.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.casabaca.persona.modelo.Persona;
import ec.casabaca.persona.servicio.PersonaServicio;

@Named
@RequestScoped
public class ListaPersonasControlador implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	VerPersonaControlador verPersonaControlador;
	@EJB
	PersonaServicio personaServicio;
	
	List<Persona> personas;
	private Persona persona;
	
	@PostConstruct
	public void inicializarPersonaControlador () {
		System.out.println("buscar controlador");
		personas = this.personaServicio.buscarPersonasCriteria();
	}
	
	public String getHola () {
		return "hello";
	}
	
	public String seleccionarPersona () {
		System.out.println("persona id " + persona.getId());
		this.verPersonaControlador.setPersona(this.personaServicio.buscarPersonaConDepartamento(persona.getId()));
		return "/pages/persona/verPersona.xhtml";
	} 
	
	

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
