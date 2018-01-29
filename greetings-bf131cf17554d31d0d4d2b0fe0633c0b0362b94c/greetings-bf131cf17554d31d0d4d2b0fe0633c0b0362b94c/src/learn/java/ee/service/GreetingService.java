package learn.java.ee.service;

import learn.java.ee.annotations.Fancy;
import learn.java.ee.annotations.GreetingReceived;
import learn.java.ee.annotations.Salutation;
import learn.java.ee.bean.Greeting;
import learn.java.ee.bean.GreetingException;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Ashish.Agarwal on 05/07/2016.
 */
@Path("greet")
public class GreetingService {

    @Inject @Fancy
    Greeting greeting;

    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String greet(@PathParam("name") String name) {
        if(name.length() < 5) {
            throw new GreetingException("Name must be atleast 6 digit long!!!");
        }
        return greeting.greet(name);
    }
}
