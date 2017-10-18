package ec.casabaca.roster.controller;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import ec.casabaca.controlador.ControladorBase;
import ec.casabaca.roster.model.Player;
import ec.casabaca.roster.web.resftul.PlayerRestfulClient;
import ec.casabaca.roster.web.soap.api.client.PlayerWSClient;

@Named
@ViewScoped
public class ViewPlayerWSController extends ControladorBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1408426370834927191L;
	
	@Inject
	private PlayerRestfulClient playerRestfulClient;
	@Inject
	PlayerWSClient playerWSClient;
	
	private Long idPlayer;
	private Player soapPlayer, restPlayer;
	private String playerJSON;
	
	public void invokeWS () {
		try {
			restPlayer = playerRestfulClient.findAsObject(idPlayer);
		} catch (Exception e) {
			restPlayer = new Player();
			this.adicionarMensajeError("Error ejecutando rest " + e.getMessage());
		}
		playerJSON = playerRestfulClient.findAsJSONString(idPlayer);
		try {
			soapPlayer = playerWSClient.findPlayer(idPlayer);
		} catch (Exception e) {
			soapPlayer = new Player();
			this.adicionarMensajeError("Error ejecutando soap " + e);
		}
	}

	public Long getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(Long idPlayer) {
		this.idPlayer = idPlayer;
	}

	public Player getSoapPlayer() {
		return soapPlayer;
	}

	public Player getRestPlayer() {
		return restPlayer;
	}

	public String getPlayerJSON() {
		return playerJSON;
	}

}
