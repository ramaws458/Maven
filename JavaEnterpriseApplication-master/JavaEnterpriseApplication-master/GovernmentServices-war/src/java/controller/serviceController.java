/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Service;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zaeem
 */
@ManagedBean(name = "serviceController")
//@Named(value = "serviceController")
@SessionScoped
public class serviceController implements Serializable {

    @EJB
    private ServiceControllerRemote serviceController1;

    private int serviceNumber;
    private Service service;
    
    private List<Service> services = new ArrayList<Service>();
    private String serviceName;
    private String serviceType;
    
    private List<String> serviceTypes = new ArrayList<>();

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }    

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    
    
    

    /**
     * Creates a new instance of testController
     */
    public serviceController() {
        serviceNumber = 0;
        
        
        
        if (FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().containsKey("serviceID")) {
            serviceNumber = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("serviceID"));
            
            if(serviceController1 == null) {
                System.out.println("is null");
            }
            
        }

        //serviceNumber = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext()
          //      .getRequestParameterMap().get("serviceID"));          
        
        
        serviceName = "";
        serviceType = "";
        
        if(serviceNumber != 0) {    // it is view
            System.out.println("view service:"+serviceNumber);
        }
    }

    public List<Service> getServices() {        
        System.out.println("search called"+serviceNumber);
        services = serviceController1.searchServices(String.valueOf(serviceNumber), serviceName, serviceType);      
        System.out.println(""+this.serviceName);
        return services;
    }

    public String post() {
        //Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        //String action = params.get("action");
        //System.out.println("called"+action+serviceName);
        return "index";
    }

}
