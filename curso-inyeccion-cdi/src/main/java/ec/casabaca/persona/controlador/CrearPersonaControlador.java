package ec.casabaca.persona.controlador;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import ec.casabaca.persona.servicio.PersonaServicio;

@Named
@SessionScoped
public class CrearPersonaControlador implements Serializable {

	@EJB
	PersonaServicio personaServicio;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	private Date fechaNacimiento;
	
	@PostConstruct
	public void inicializarCrearControlador () {
		nombre = null;
		fechaNacimiento = null;
	}
	
	public void crearPersona () {
		try {
			this.personaServicio.crearPersona(this.personaServicio.instanciarPersona(nombre, fechaNacimiento));
		} catch (Exception e) {
			System.out.println("se captura en controlador " + e.getClass().getName() + e.getMessage());
			FacesContext.getCurrentInstance().addMessage("crear-button", new FacesMessage("ERROR " + e.getCause().getMessage()));
		}
		inicializarCrearControlador ();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
