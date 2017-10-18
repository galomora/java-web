package ec.casabaca.util;

public enum MensajeId {
	CREATE_PLAYER_SUCCESS ("casabaca.curso.jee.roster.player.create.message.success"),
	CREATE_PLAYER_ERROR ("casabaca.curso.jee.roster.player.create.message.error"),
	CREATE_TEAM_SUCCESS ("casabaca.curso.jee.roster.team.create.message.success"),
	CREATE_TEAM_ERROR ("casabaca.curso.jee.roster.team.create.message.error");
	
	private String key;
	
	private MensajeId (String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
	
}
