package learn.java.ee.bean;

/**
 * Created by Ashish.Agarwal on 07/07/2016.
 */
public class GreetingException extends RuntimeException {
    public GreetingException() {
    }

    public GreetingException(String message) {
        super(message);
    }
}
