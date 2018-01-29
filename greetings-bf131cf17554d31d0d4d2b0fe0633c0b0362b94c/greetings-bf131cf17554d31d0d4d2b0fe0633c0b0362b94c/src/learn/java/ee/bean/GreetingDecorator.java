package learn.java.ee.bean;

import learn.java.ee.annotations.GreetingReceived;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

/**
 * Created by Ashish.Agarwal on 05/07/2016.
 */
@Decorator
@Priority(Interceptor.Priority.APPLICATION+10)
public abstract class GreetingDecorator implements Greeting {

    @Delegate
    @Inject
    @Any
    Greeting greeting;

    @Inject @GreetingReceived
    Event<String> greetingReceivedEvent;

    @Override
    public String greet(String name) {
        greetingReceivedEvent.fire(name);
        return "@@" + greeting.greet(name) + "@@";
    }
}
