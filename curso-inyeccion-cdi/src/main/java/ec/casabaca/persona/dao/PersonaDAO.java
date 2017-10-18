package ec.casabaca.persona.dao;

import java.util.List;

import javax.ejb.Local;

import ec.casabaca.persona.modelo.Persona;

@Local
public interface PersonaDAO {
	void crearPersona (Persona persona) throws Exception;
	List<Persona> buscarPersonasJPQL();
	List<Persona> buscarPersonasCriteria ();
	List<Persona> buscarPersonasPorNombre (String nombre);
	Persona obtenerPersonaYDepartamento (Long idPersona);
	Persona actualizarPersona (Persona persona);
}

