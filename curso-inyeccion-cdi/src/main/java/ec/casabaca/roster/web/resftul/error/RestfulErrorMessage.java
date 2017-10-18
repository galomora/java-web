package ec.casabaca.roster.web.resftul.error;

import java.io.Serializable;

import javax.ws.rs.WebApplicationException;

public class RestfulErrorMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int status;
	private String restMessage;
	
	public RestfulErrorMessage(RestfulException exception) {
		status = exception.getStatus();
		restMessage = exception.getMessage();
	}
	
	public RestfulErrorMessage(WebApplicationException exception) {
		status = exception.getResponse().getStatus();
		restMessage = exception.getMessage();
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRestMessage() {
		return restMessage;
	}
	public void setRestMessage(String restMessage) {
		this.restMessage = restMessage;
	}
	
}
