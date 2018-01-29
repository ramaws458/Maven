/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Zaeem
 */
@Entity
@Table(name = "ServiceUser")



public class ServiceUser implements Serializable {

    @Id
    @Column(name="UserId")
    private int UserId;
    private String LastName;
    private String FirstName;
    private String Email;
    private String Password;
    private int Type;
    private String Address;
    private String Phone;

    public ServiceUser() {
        
    }
    public ServiceUser(ServiceUser su) {
        this.UserId = su.UserId;
        this.LastName = su.LastName;
        this.FirstName = su.FirstName;
        this.Email = su.Email;
        this.Password = su.Password;
        this.Type = su.Type;
        this.Address = su.Address;
        this.Phone = su.Phone;
    }
    
    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
