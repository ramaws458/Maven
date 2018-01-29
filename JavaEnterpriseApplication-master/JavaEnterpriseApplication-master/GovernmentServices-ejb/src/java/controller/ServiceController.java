/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Service;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Zaeem
 */
@Stateless
public class ServiceController implements ServiceControllerRemote {

    private static final String PERSISTENCE_UNIT = "GovernmentServices-commonPU";

    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;
    
    private List<Service> services = new ArrayList<Service>();

    public ServiceController() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    @Override
    public void businessMethod() {
        System.out.println("testing the business method now:");
        System.out.println(this.entityManager.createNamedQuery(Service.GET_ALL).getResultList());
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Service> getAllServices() {
        return this.entityManager.createNamedQuery(Service.GET_ALL).getResultList();
    }
    
    

    @Override
    public List<Service> searchServices(String serviceNumber, String serviceName, String serviceType) {
       
        TypedQuery<Service> query = entityManager.createNamedQuery(Service.GET_BY_FILTERS, Service.class);
        query.setParameter("serviceNo", Integer.parseInt(serviceNumber));
        query.setParameter("serviceName", "%"+serviceName+"%");
        query.setParameter("serviceType", serviceType);
        services = query.getResultList();
        return services;
    }

    @Override
    public void addService(Service service) {
        entityManager.persist(service);
    }

    @Override
    public void editService(Service service) {
        entityManager.merge(service);
    }

    @Override
    public Service getServiceById(int serviceNumber) {
        System.out.println("fetching the service number:"+serviceNumber);
        TypedQuery<Service> query = entityManager.createNamedQuery(Service.GET_BY_FILTERS, Service.class);
        query.setParameter("serviceNo", serviceNumber);        
        Service service = query.getSingleResult();
        return service;
    }
    
    
    
    
    
    
}
