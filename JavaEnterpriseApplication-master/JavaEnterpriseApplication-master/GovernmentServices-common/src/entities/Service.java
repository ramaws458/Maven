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
@Table(name = "Service")

@NamedQueries({
    @NamedQuery(name = Service.GET_ALL,
            query = "SELECT s FROM Service s "),
    @NamedQuery(name = Service.GET_BY_FILTERS,
            query = "SELECT s FROM Service s where s.ServiceName like :serviceName or s.ServiceNo = :serviceNo or s.Type = :serviceType"),
    @NamedQuery(name = Service.GET_BY_ID,
            query = "SELECT s FROM Service s where s.ServiceNo = :serviceNo")
    
})
public class Service implements Serializable {

    public static final String GET_ALL = "Service.getAll";
    public static final String GET_BY_ID = "Service.getById";
    public static final String GET_BY_FILTERS = "Service.getByFilters";

    @Id
    @Column(name = "ServiceNo")
    private int ServiceNo;
    private String ServiceName;
    private String Type;
    private String Thumbnail;
    private String Description;

    public Service() {

    }

    public Service(Service s) {
        this.ServiceNo = s.ServiceNo;
        this.ServiceName = s.ServiceName;
        this.Type = s.Type;
        this.Thumbnail = s.Thumbnail;
        this.Description = s.Description;
    }

    public int getServiceNo() {
        return ServiceNo;
    }

    public void setServiceNo(int ServiceNo) {
        this.ServiceNo = ServiceNo;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String ServiceName) {
        this.ServiceName = ServiceName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(String Thumbnail) {
        this.Thumbnail = Thumbnail;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
