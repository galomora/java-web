package ec.casabaca.roster.model.json;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonWriter;

import ec.casabaca.roster.model.Player;
import ec.casabaca.roster.model.Team;

@ApplicationScoped
public class PlayerJsonWriter implements Serializable {
	
	public String write (Player player) {
		StringWriter stringWriter = new StringWriter();
		try (JsonWriter jsonWriter = Json.createWriter(stringWriter)) {
			jsonWriter.writeObject(getJsonPlayer(player));
		}
		return stringWriter.toString();
	}
	
	public JsonObject getJsonPlayer (Player player) {
		JsonObject model = Json.createObjectBuilder().
				add("id", player.getId()).
				add("name", player.getName()).
				add("position", player.getPosition().toString()).
				add("salary", player.getSalary()).
				add("teams", createTeamsList (player.getTeams())).build();
		return model;
	}
	
	private JsonArray createTeamsList (List<Team> teams) {
		JsonArrayBuilder builder = Json.createArrayBuilder();
		if (teams != null) {
			for (Team team : teams) {
				builder.add(createTeam (team));
			}
		}
		return builder.build();
	}
	
	private JsonObject createTeam (Team team) {
		JsonObject model = Json.createObjectBuilder().
				add ("name", team.getName()).
				add ("city", team.getCity()).
				build();
		return model;
	}
}
