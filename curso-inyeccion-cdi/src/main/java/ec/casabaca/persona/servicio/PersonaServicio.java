package ec.casabaca.persona.servicio;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import ec.casabaca.persona.dao.DepartamentoDAO;
import ec.casabaca.persona.dao.PersonaDAO;
import ec.casabaca.persona.modelo.Departamento;
import ec.casabaca.persona.modelo.Persona;

@LocalBean
@Stateless
@TransactionManagement (TransactionManagementType.BEAN)
public class PersonaServicio {
	@EJB
	private PersonaDAO personaDAO;
	@EJB
	private DepartamentoDAO departamentoDAO;
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public Persona crearPersona (Persona persona) throws Exception {
		try {this.personaDAO.crearPersona(persona);
		return persona;
		} catch (Throwable e) {
			System.out.println("se captura en servicio " + e.getClass().getName());
			throw new Exception ("No se puede crear " + e.getMessage(), e);
		}
		
	}
	
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public List<Persona> buscarPersonasCriteria () {
		return this.personaDAO.buscarPersonasCriteria();
	}
	
	public Persona instanciarPersona (String nombre, Date fechaNacimiento) {
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setFechaNacimiento(fechaNacimiento);
		return persona;
	}
	
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public Departamento buscarDepartamentoYPersonas (Long idDepartamento) {
		Departamento departamento = departamentoDAO.buscarDepartamento(idDepartamento);
		departamento.getEmpleados().size();
		return departamento;
	}
	
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public Persona buscarPersonaConDepartamento (Long idPersona) {
		return this.personaDAO.obtenerPersonaYDepartamento(idPersona);
	}
	
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public Persona actualizarPersona (Persona persona) {
		return this.personaDAO.actualizarPersona(persona);
	}
}
