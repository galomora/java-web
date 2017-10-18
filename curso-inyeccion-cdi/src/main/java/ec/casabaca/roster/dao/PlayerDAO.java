package ec.casabaca.roster.dao;

import ec.casabaca.dao.GenericDao;
import ec.casabaca.roster.model.Player;

public interface PlayerDAO extends GenericDao<Player, Long> {
	
	public Player findPlayer (Long idPlayer);

}
