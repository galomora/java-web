package ec.casabaca.roster.controller.flow;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.casabaca.controlador.ControladorBase;
import ec.casabaca.roster.model.Team;
import ec.casabaca.roster.service.PlayerService;
import ec.casabaca.roster.web.teams.flow.TeamsFlowBean;
import ec.casabaca.util.MensajeId;
import ec.casabaca.util.ResourceBundleUtil;

@Named
@SessionScoped
public class NewTeamFlowController extends ControladorBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB PlayerService playerService;
	
	@Inject
	ResourceBundleUtil resourceBundleUtil;
	
	@Inject 
	TeamsFlowBean teamsFlowBean;
	
	private Team team;
	
	public String addTeam () {
		initNewTeamController ();
		return "/teamsFlow/newTeam.xhtml?faces-redirect=true";
	}

	private void initNewTeamController() {
		team = new Team();
	}
	
	public String saveTeam () {
		try {
			team = this.playerService.createTeam(team) ;
			this.adicionarMensajeInfo(resourceBundleUtil.getValuePropiedadesCurso(MensajeId.CREATE_PLAYER_SUCCESS));
			teamsFlowBean.setTeam(team);
			return "/teamsFlow/viewTeam.xhtml";
		} catch (Throwable e) {
			e.printStackTrace();
			this.adicionarMensajeError(resourceBundleUtil.getValuePropiedadesCurso(MensajeId.CREATE_PLAYER_ERROR) + ": " + e.getMessage());
			return null;
		}
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	
}
