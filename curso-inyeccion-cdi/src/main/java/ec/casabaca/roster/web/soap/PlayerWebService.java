package ec.casabaca.roster.web.soap;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.casabaca.roster.model.Player;
import ec.casabaca.roster.service.PlayerService;

@WebService (name="playerWebService", serviceName = "playerWebService" )
@Stateless
public class PlayerWebService {
	
	@EJB
	PlayerService playerService;
	
	@WebMethod
	public Player findPlayer (Long id) {
		return playerService.findPlayer(id);
	}
	
}
