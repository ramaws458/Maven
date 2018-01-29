package learn.java.ee.bean;

import javax.inject.Named;

/**
 * Created by Ashish.Agarwal on 04/07/2016.
 */
public class SimpleGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return "Hello " + name;
    }

}