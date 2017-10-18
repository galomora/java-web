package ec.casabaca.persona.servicio;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@Stateful
@TransactionManagement (TransactionManagementType.BEAN)
public class BeanManagedTransactionStateful {
	@PersistenceContext (unitName="cursoPU")
	protected EntityManager em;
	
	@Resource
	protected EJBContext ejbContext;
	
	UserTransaction userTransaction;
	
	@PostConstruct
	public void init () {
		userTransaction = ejbContext.getUserTransaction();
	}
	
	public void ejecutarLogica () throws IllegalStateException, SystemException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException, NotSupportedException {
		userTransaction.begin();
		try {
			// operaciones
		} catch (Exception e) {
			userTransaction.setRollbackOnly();
		} finally {
			userTransaction.commit();
		}
	}
	
	// mucha logica
	
	public void metodoFinal () throws IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException, SystemException {
		userTransaction.commit();
	}
}
