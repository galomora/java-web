package ec.casabaca.roster.web.teams.flow;

import java.io.Serializable;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;

import ec.casabaca.roster.model.Team;

@Named
@FlowScoped ("teamsFlow")
public class TeamsFlowBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Team team;
	
	public String getReturnFromFlow () {
		return "/pages/roster/teams.xhtml";
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
}
