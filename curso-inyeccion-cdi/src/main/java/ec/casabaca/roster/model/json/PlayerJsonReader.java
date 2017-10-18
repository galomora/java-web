package ec.casabaca.roster.model.json;

import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import ec.casabaca.roster.model.Player;
import ec.casabaca.roster.model.PlayerPosition;
import ec.casabaca.roster.model.Team;

public class PlayerJsonReader implements Serializable {
	public Player createPlayer (String playerJson) {
		JsonObject model = createRoot (playerJson);
		Player player = new Player ();
		player.setId(model.getJsonNumber("id").longValue());
		player.setName (model.getString("name"));
		player.setPosition(PlayerPosition.valueOf(model.getString("position")));
		player.setSalary(model.getJsonNumber("salary").doubleValue());
		JsonArray teamsArray = model.getJsonArray("teams");
		player.setTeams(createTeams (teamsArray));
		return player;
	}
	
	private JsonObject createRoot (String playerJson) {
		JsonReader jsonReader = Json.createReader(new StringReader(playerJson));
		JsonObject model = jsonReader.readObject();
		return model;
	}
	
	public List<Team> createTeams (JsonArray teamsArray) {
		List<Team> teams = new ArrayList<Team> ();
		for (int i = 0; i < teamsArray.size(); i++) {
			teams.add(createTeam (teamsArray.getJsonObject(i)));
		}
		return teams;
	}

	private Team createTeam(JsonObject teamObject) {
		Team team = new Team ();
		team.setId(teamObject.getJsonNumber("id").longValue());
		team.setName(teamObject.getString("name"));
		team.setCity(teamObject.getString("city"));
		return team;
	}
}
