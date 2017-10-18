package ec.casabaca.roster.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ec.casabaca.roster.model.Team;
import ec.casabaca.roster.service.PlayerService;

@Named
@RequestScoped
public class TeamsController {
	@EJB
	PlayerService playerService;
	
	private List<Team> teams;

	@PostConstruct
	public void initPlayersController () {
		teams = this.playerService.searchTeams();
	}

	public List<Team> getTeams() {
		return teams;
	}
	
	
}
