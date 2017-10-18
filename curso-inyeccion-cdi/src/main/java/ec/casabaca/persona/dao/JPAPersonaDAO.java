package ec.casabaca.persona.dao;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import ec.casabaca.persona.dao.exception.DAOException;
import ec.casabaca.persona.modelo.Persona;
import ec.casabaca.persona.modelo.Persona_;

@Stateless
public class JPAPersonaDAO implements PersonaDAO {
	@PersistenceContext (unitName="cursoPU")
	protected EntityManager em;
	
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public void crearPersona (Persona persona) throws DAOException {
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
			Set<ConstraintViolation<Persona>> constraints = validator.validate(persona);
			if (! constraints.isEmpty()) {
				String mensaje = "";
				for (ConstraintViolation<Persona> constraintViolation : constraints) {
					mensaje = mensaje + constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage();
			    }
				throw new DAOException("No se puede guardar: " + mensaje);
			}
			this.em.persist(persona);
	}
	
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public List<Persona> buscarPersonasCriteria () {
		System.out.println("buscar dao");
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Persona> query = builder.createQuery(Persona.class);
		Root<Persona> personaRoot = query.from(Persona.class);
		query.select(personaRoot);
		return this.em.createQuery(query).getResultList();
	}

	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public List<Persona> buscarPersonasJPQL() {
		return this.em.createQuery("select o from Persona o").getResultList();
	}

	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public List<Persona> buscarPersonasPorNombre(String nombre) {
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Persona> query = builder.createQuery(Persona.class);
		Root<Persona> personaRoot = query.from(Persona.class);
		Predicate condicionWhere = builder.like(personaRoot.get(Persona_.nombre), nombre);
		Predicate condicionNotNull = builder.isNotNull(personaRoot.get(Persona_.nombre));
		query.where(builder.and(condicionWhere, condicionNotNull));
		return this.em.createQuery(query).getResultList();
	}
	
	public Persona obtenerPersonaYDepartamento (Long idPersona) {
		return (Persona) this.em.createQuery("select o from Persona o left join fetch o.departamento where o.id = :ID").setParameter("ID", idPersona).getSingleResult();
	}

	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public Persona actualizarPersona(Persona persona) {
		this.em.lock(persona, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		return this.em.merge(persona);
	}
	
}
