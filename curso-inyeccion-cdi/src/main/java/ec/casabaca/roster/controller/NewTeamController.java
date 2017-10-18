package ec.casabaca.roster.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.casabaca.controlador.ControladorBase;
import ec.casabaca.roster.model.Team;
import ec.casabaca.roster.service.PlayerService;
import ec.casabaca.util.MensajeId;
import ec.casabaca.util.ResourceBundleUtil;

@Named
@SessionScoped
public class NewTeamController extends ControladorBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB PlayerService playerService;
	
	@Inject
	ResourceBundleUtil resourceBundleUtil;

	private Team team;
	
	public String addTeam () {
		initNewTeamController ();
		return "/pages/roster/newTeam.xhtml?faces-redirect=true";
	}

	private void initNewTeamController() {
		team = new Team();
	}
	
	public String saveTeam () {
		try {
			team = this.playerService.createTeam(team) ;
			this.adicionarMensajeInfo(resourceBundleUtil.getValuePropiedadesCurso(MensajeId.CREATE_PLAYER_SUCCESS));
			return "/pages/roster/viewTeam.xhtml";
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
