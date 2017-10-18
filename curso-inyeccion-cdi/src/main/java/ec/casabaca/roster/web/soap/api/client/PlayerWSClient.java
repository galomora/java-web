package ec.casabaca.roster.web.soap.api.client;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import ec.casabaca.roster.model.Player;
import ec.casabaca.roster.model.PlayerPosition;
import ec.casabaca.roster.model.Team;
import ec.casabaca.roster.web.resftul.error.RestfulException;
import ec.casabaca.roster.web.soap.client.PlayerWebService;
import ec.casabaca.roster.web.soap.client.PlayerWebService_Service;

@RequestScoped
public class PlayerWSClient {
	
	public Player findPlayer (Long id) throws Exception {
		PlayerWebService_Service service1 = new PlayerWebService_Service();
	    PlayerWebService port1 = service1.getPlayerWebServicePort();
	    return convertir (port1.findPlayer(id));
	}
	
	private Player convertir (ec.casabaca.roster.web.soap.client.Player playerWS) throws Exception {
		Player player = new Player();
		if (playerWS == null ) { throw new Exception("player not found"); }
		player.setId(playerWS.getId());
		player.setName(playerWS.getName());
		player.setPosition(PlayerPosition.valueOf(playerWS.getPosition().toString()));
		player.setSalary(playerWS.getSalary());
		player.setTeams(this.convertirTeams (playerWS.getTeams()));
		return player;
	}

	private List<Team> convertirTeams(List<ec.casabaca.roster.web.soap.client.Team> teamsWS) {
		if (teamsWS == null) { return null; }
		List<Team> teams = new ArrayList<>();
		for (ec.casabaca.roster.web.soap.client.Team teamWS : teamsWS) {
			teams.add(convertirTeam (teamWS));
		}
		return teams;
	}

	private Team convertirTeam(ec.casabaca.roster.web.soap.client.Team teamWS) {
		Team team = new Team();
		team.setCity(teamWS.getCity());
		team.setId (teamWS.getId());
		team.setName(teamWS.getName());
		return team;
	}
	
}
