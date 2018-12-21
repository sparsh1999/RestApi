package org.sparsh.MessengerAPI.exception;
import org.sparsh.MessengerAPI.resources.Exception;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// it lets jersey know that there is a exception mapper 
//if we typecast the generic into Throwable here then it will catch all exceptions
// however there is a herirachy for example if datanotfoundexception is called then it will be called

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		// TODO Auto-generated method stub
		Exception dataException = new Exception(exception.getMessage(),404,
                "www.google.com");
		
		return Response.status(Status.NOT_FOUND).entity(dataException).build();
	}

}
