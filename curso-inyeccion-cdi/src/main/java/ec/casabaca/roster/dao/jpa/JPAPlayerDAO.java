package ec.casabaca.roster.dao.jpa;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.casabaca.dao.GenericDaoImpl;
import ec.casabaca.roster.dao.PlayerDAO;
import ec.casabaca.roster.model.Player;

@Stateless
public class JPAPlayerDAO extends GenericDaoImpl<Player, Long> implements PlayerDAO {

	@Override
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public Player findPlayer(Long idPlayer) {
		return (Player) this.em.createQuery("select o from Player o where o.id = :ID").
				setParameter("ID", idPlayer).getSingleResult();
	}
	
}
