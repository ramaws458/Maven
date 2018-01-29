package learn.java.ee.websocket;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by Ashish.Agarwal on 05/07/2016.
 */
@ServerEndpoint("/greeting")
public class GreetingServer {
    /*@OnMessage
    public String handleMessage(String greeting) {
        return "Greeting : " + greeting + " received at Server";
    }*/

    @OnMessage
    public void handleMessage(Session client, String greeting) {
        System.out.println("Greeting received at server : " + greeting);
        try {
            client.getBasicRemote().sendText("Hello to you too!!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
