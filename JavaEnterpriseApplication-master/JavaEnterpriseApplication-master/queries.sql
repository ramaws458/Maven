Create table User(
UserID          INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
LAST_NAME VARCHAR(20),
FIRST_NAME VARCHAR(20),
Email VARCHAR(50),
Password VARCHAR(50),
Type INTEGER, 
Address VARCHAR(100),
Phone VARCHAR(20)
);

Create table "Service"(
Service_ID         INTEGER NOT NULL 
                PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                (START WITH 1, INCREMENT BY 1),
Service_Name VARCHAR(20),
Type INTEGER, 
Thumbnail VARCHAR(100),
Description VARCHAR(250)
);

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Serviceuser;
import entities.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Zaeem
 */
@Stateless
public class ServiceController implements ServiceControllerRemote {

    private EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public void businessMethod() {
        System.out.println("Call db here:");

    }

    public ServiceController() {
        entityManagerFactory = Persistence.createEntityManagerFactory("GovernmentServices-ejbPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void addUser(Serviceuser parameter) {
        System.out.println("Add user here:" + parameter.getAddress());
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            System.out.println("Inside try");
            entityManager.persist(parameter);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

    }

    @Override
    public void addUser(User user) {
    }

}
