package ec.casabaca.roster.controller.flow;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.casabaca.roster.model.Team;
import ec.casabaca.roster.web.teams.flow.TeamsFlowBean;

@Named
@RequestScoped
public class ViewTeamFlowController {
	@Inject 
	TeamsFlowBean teamsFlowBean;
	
	public Team getTeam () {
		return teamsFlowBean.getTeam();
	}
	
	public String getBack () {
		return teamsFlowBean.getReturnFromFlow();
	}
}
