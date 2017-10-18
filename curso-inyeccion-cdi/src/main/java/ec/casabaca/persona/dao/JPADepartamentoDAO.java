package ec.casabaca.persona.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.casabaca.persona.modelo.Departamento;

@Local (DepartamentoDAO.class)
@Stateless
public class JPADepartamentoDAO implements DepartamentoDAO {

	@PersistenceContext (unitName="cursoPU")
	protected EntityManager em;
	
	public Departamento buscarDepartamento(Long idDepartamento) {
		return this.em.find(Departamento.class, idDepartamento);
	}
	
}
