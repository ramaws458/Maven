package learn.java.ee.websocket;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.IOException;

/**
 * Created by Ashish.Agarwal on 05/07/2016.
 */
@ClientEndpoint
public class GreetingClient {

    @OnOpen
    public void onOpen(Session session) {
        try {
            session.getBasicRemote().sendText("Hello World!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @OnMessage
    public void processMessage(String greeting) {
        System.out.println("Greeting received from server at client!!");
        System.out.println(greeting);
    }
}
