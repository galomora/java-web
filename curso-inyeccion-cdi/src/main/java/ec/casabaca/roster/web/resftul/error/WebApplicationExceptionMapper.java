package ec.casabaca.roster.web.resftul.error;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

	@Override
	public Response toResponse(WebApplicationException exception) {
		System.out.println("procesa web exception " + exception.getMessage() + exception.getResponse().getStatus());
		RestfulErrorMessage errorMessage = new RestfulErrorMessage(exception);
		return Response.status(errorMessage.getStatus()).entity(
				errorMessage).type(MediaType.APPLICATION_JSON).build();
	}
	
}
