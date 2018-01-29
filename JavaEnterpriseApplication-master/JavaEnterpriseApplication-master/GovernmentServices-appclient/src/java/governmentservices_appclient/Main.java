/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package governmentservices_appclient;

import controller.ServiceControllerRemote;
import entities.ServiceUser;
import gui.serviceList;
import javax.ejb.EJB;

/**
 *
 * @author Zaeem
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    //@EJB
    //private static ServiceControllerRemote service;

    public static void main(String[] args) {
        // TODO code application logic here        
        //service.businessMethod();
        System.out.println("App client is up and running now");
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new serviceList().setVisible(true);
            }
        });
    }

}
