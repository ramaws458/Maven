package learn.java.ee.bean;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Ashish.Agarwal on 07/07/2016.
 */
@Provider
public class GreetingExceptionMapper implements ExceptionMapper<GreetingException> {
    @Override
    public Response toResponse(GreetingException e) {
        return Response
                .status(Response.Status.PRECONDITION_FAILED)
                .entity(e.getMessage())
                .build();
    }
}
