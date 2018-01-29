package learn.java.ee.bean;

import learn.java.ee.annotations.Salutation;

import javax.enterprise.inject.Produces;

/**
 * Created by Ashish.Agarwal on 05/07/2016.
 */
public class Helper {
    @Produces @Salutation
    String getSalution() {
        return "Mr. ";
    }
}
