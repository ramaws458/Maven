/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Service;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Zaeem
 */
@Remote
public interface ServiceControllerRemote {

    void businessMethod();

    List<Service> getAllServices();

    List<Service> searchServices(String serviceNumber, String serviceName, String serviceType);

    void addService(Service service);

    void editService(Service service);

    Service getServiceById(int serviceNumber);
    
}
