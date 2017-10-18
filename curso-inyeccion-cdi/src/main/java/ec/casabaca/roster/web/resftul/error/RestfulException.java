package ec.casabaca.roster.web.resftul.error;

import javax.ws.rs.core.Response;

public class RestfulException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int status;
	private String restMessage;
	
	public RestfulException() {
		
	}
	
	public RestfulException(int status, String message) {
		super(message);
		this.status = status;
		this.restMessage = message;
	}
	
	
	public RestfulException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
		this.restMessage = message;
	}

	public RestfulException(String message, Throwable cause) {
		super(message, cause);
		this.status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
		this.restMessage = message;
	}

	public RestfulException(String message) {
		super(message);
		this.status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
	}

	public RestfulException(Throwable cause) {
		super(cause);
		this.status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
		this.restMessage = cause.getMessage();
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
