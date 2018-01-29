package learn.java.ee.dao;

import learn.java.ee.entity.Person;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Ashish on 7/19/2016.
 */
@Named
public class PersonDao {
    @PersistenceContext(unitName="person")
    private EntityManager entityManager;

    public String findById(Integer id) {
        return entityManager.find(Person.class, id).getName();
    }
}
