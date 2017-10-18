package ec.casabaca.roster.web.resftul;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.casabaca.roster.model.Player;


@RequestScoped
public class PlayerRestfulClient implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JsonObject findAsJSON (Long id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/curso-inyeccion-cdi/rest/players/player").
				path("{id}").resolveTemplate("id", id);
		System.out.println("dir consultada " + target.getUri().toString());
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		System.out.println("estado en response " + response.getStatus());
		client.close();
		return response.readEntity(JsonObject.class);
		
	}
	
	public Player findAsObject (Long id) throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/curso-inyeccion-cdi/rest/players/player").
				path("{id}").resolveTemplate("id", id);
		System.out.println("dir consultada " + target.getUri().toString());
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		if (! (Response.Status.OK.getStatusCode() == response.getStatus())) {
			client.close();
			throw new Exception ("Error al consultar como objeto " + response.readEntity(String.class));
		}
		client.close();
		return response.readEntity(Player.class);
	}
	
	public String findAsJSONString (Long id) {
		JsonObject jsonObject = findAsJSON (id);
		if (jsonObject != null) {
			return jsonObject.toString();
		}
		return "{no encontrado}";
	}
	
}
