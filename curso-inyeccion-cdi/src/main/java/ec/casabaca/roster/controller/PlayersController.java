package ec.casabaca.roster.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ec.casabaca.roster.model.Player;
import ec.casabaca.roster.service.PlayerService;


@Named
@RequestScoped
public class PlayersController {

	@EJB
	PlayerService playerService;
	
	private List<Player> players;

	@PostConstruct
	public void initPlayersController () {
		players = this.playerService.searchPlayers();
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
}
