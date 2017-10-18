package ec.casabaca.roster.web.resftul;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.casabaca.roster.model.Player;
import ec.casabaca.roster.service.PlayerService;
import ec.casabaca.roster.web.resftul.error.RestfulException;

@Path ("/players")
@Stateless
@LocalBean
public class PlayerRestfulService {
	
	@EJB
	PlayerService playerService;
	
	@GET
	@Path ("/player/{id}")
	@Produces (MediaType.APPLICATION_JSON)
	@TransactionAttribute (TransactionAttributeType.NOT_SUPPORTED)
	public Player getPlayer (@PathParam (value="id") Long id) throws RestfulException {
		try {
			return playerService.findPlayer(id);
		}
		catch (EJBTransactionRolledbackException e) {
			System.out.println("ejb rollback " + e.getMessage());
//			e.printStackTrace();
			throw new RestfulException(e);
		}
		
	}
}
