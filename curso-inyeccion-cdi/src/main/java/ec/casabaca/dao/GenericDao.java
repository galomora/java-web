package ec.casabaca.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Acceso a datos generico
 *
 */
public interface GenericDao <T, ID extends Serializable> {
	
	T create(T t);
	T saveOrUpdate(T t);
    T update(T t);
    T find(ID id);
    void delete(ID id);
    List<T> findAll();
    void flush ();
    void detach(T t);
}
