package ec.casabaca.roster.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import ec.casabaca.controlador.ControladorBase;
import ec.casabaca.roster.model.Player;
import ec.casabaca.roster.model.PlayerPosition;
import ec.casabaca.roster.model.Team;
import ec.casabaca.roster.model.json.PlayerJsonWriter;
import ec.casabaca.roster.service.PlayerService;
import ec.casabaca.util.MensajeId;
import ec.casabaca.util.ResourceBundleUtil;

@Named
@ConversationScoped
public class NewPlayerController extends ControladorBase implements Serializable {

	@EJB
	private PlayerService playerService;

	@Inject
	ResourceBundleUtil resourceBundleUtil;
	
	@Inject
	private Conversation conversation;
	
	@Inject
	private PlayerJsonWriter playerJsonWriter;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Player player;
	private Long idTeam;
	private List<Team> teams;
	private Team team;
	
	
	public void initNewPlayerController () {
		System.out.println("init playercontroller");
		player = new Player();
		searchTeams ();
	}
	
	private void searchTeams () {
		teams = this.playerService.searchTeams();
	}
	
	public String addPlayer () {
		initNewPlayerController ();
		return "/pages/roster/newPlayer.xhtml?faces-redirect=true";
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String savePlayer () {
		System.out.println("Save Player Method");
		try {
			player = this.playerService.createPlayer (player);
			player.setJson(playerJsonWriter.write(player));
			this.adicionarMensajeInfo(resourceBundleUtil.getValuePropiedadesCurso(MensajeId.CREATE_PLAYER_SUCCESS));
			searchTeams ();
			return "/pages/roster/assignToTeam.xhtml";
		} catch (Throwable e) {
			e.printStackTrace();
			this.adicionarMensajeError(resourceBundleUtil.getValuePropiedadesCurso(MensajeId.CREATE_PLAYER_ERROR) + ": " + e.getMessage());
			return null;
		}
	}
	
	public void savePlayerListener (ActionEvent event) {
		System.out.println("Save Player Listener en boton " + event.getComponent().getClientId());
	}
	
	public void startConversation () {
		System.out.println("Start Conversation");
			conversation.begin();
			System.out.println("Conversation started");
	}
	
	public void endConversation () {
		if (! conversation.isTransient()) {
			conversation.end();
		}
		
	}
	
	public String cancel () {
		return "/pages/roster/index.xhtml";
	}

	public PlayerPosition[] getPositions() {
		return PlayerPosition.values();
	}

	public Conversation getConversation() {
		return conversation;
	}

	public Long getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Long idTeam) {
		this.idTeam = idTeam;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		System.out.println("Team " + team.getId() + " " + team.getName());
		this.team = team;
	}
	
}
