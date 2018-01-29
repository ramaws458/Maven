package learn.java.ee.bean;

import learn.java.ee.annotations.Fancy;
import learn.java.ee.annotations.Salutation;
import learn.java.ee.dao.PersonDao;

import javax.inject.Inject;

/**
 * Created by Ashish.Agarwal on 04/07/2016.
 */
@Fancy
public class FancyGreeting implements Greeting {

    @Inject @Salutation
    String salutation;

    @Inject
    PersonDao personDao;

    @Override
    public String greet(String name) {
        return "Hello " + salutation + name + ":-)" + personDao.findById(1);
    }

}