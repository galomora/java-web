package ec.casabaca.roster.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import ec.casabaca.roster.dao.PlayerDAO;
import ec.casabaca.roster.dao.TeamDAO;
import ec.casabaca.roster.model.Player;
import ec.casabaca.roster.model.Team;
import ec.casabaca.roster.service.mdb.PlayerJMSProducer;

@Stateless
@LocalBean
public class PlayerService {
	@EJB
	PlayerDAO playerDAO;
	@EJB
	TeamDAO teamDAO;
	@Inject
	PlayerJMSProducer playerJMSProducer;
	
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public List<Player> searchPlayers () {
		return this.playerDAO.findAll();
	}
	
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public Player createPlayer(Player player) {
		playerJMSProducer.enviarMensaje("Se va a crear un jugador con nombre " + player.getName());
		return this.playerDAO.create(player);
	}
	
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public Team createTeam (Team team) {
		return this.teamDAO.create(team);
	}
	
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public List<Team> searchTeams () {
		return this.teamDAO.findAll();
	}
	
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public Player findPlayer (Long id) {
		Player player = this.playerDAO.findPlayer(id);
		if (player != null) {
			player.getTeams().size();
		}
		return player;
	}
}
