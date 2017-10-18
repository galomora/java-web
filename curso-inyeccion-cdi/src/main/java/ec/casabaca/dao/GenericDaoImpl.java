package ec.casabaca.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {
	
	protected static final String UNCHECKED = "unchecked";
	
	protected Class<T> type;

	@PersistenceContext(unitName="cursoPU")
	protected EntityManager em;
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
	}

	public T create(T t) {
		this.em.persist(t);
        return t;
	}
	
	public T saveOrUpdate(T t) {
		return this.em.merge(t);
	}
	
	public T update(T t) {
		return this.em.merge(t);
	}

	public void delete(ID id) {
		this.em.remove(this.em.getReference(type, id));
	}

	public T find(ID id) {
		return (T) this.em.find(type, id);
	}
	
	public void flush () {
		this.em.flush();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {		
		List<T> objects = null;
		Query query = em.createQuery("from " + type.getName(),type);
		objects = query.getResultList();
		
		return objects;
	}

	public void detach(T t){
		em.detach(t);
	}
}
