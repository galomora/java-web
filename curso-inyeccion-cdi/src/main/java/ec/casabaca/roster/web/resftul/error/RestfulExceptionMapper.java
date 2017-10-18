package ec.casabaca.roster.web.resftul.error;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
@Provider
public class RestfulExceptionMapper implements ExceptionMapper<RestfulException> {

	@Override
	public Response toResponse(RestfulException exception) {
		System.out.println("procesa restful exception " + exception.getMessage() + exception.getStatus());
		return Response.status(exception.getStatus()).entity(
				new RestfulErrorMessage(exception)).type(MediaType.APPLICATION_JSON).build();
	}

}
