package learn.java.ee.service;

import learn.java.ee.annotations.GreetingReceived;
import learn.java.ee.websocket.GreetingClient;

import javax.enterprise.event.Observes;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Ashish.Agarwal on 05/07/2016.
 */
public class EventService {
    public void handleGreeting(@Observes @GreetingReceived String name) throws DeploymentException, IOException, URISyntaxException {
        System.out.println("Greeting received for : " + name);
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri = "ws://192.168.99.100:8085/greetings/greeting";
        container.connectToServer(GreetingClient.class, URI.create(uri));
    }
}
