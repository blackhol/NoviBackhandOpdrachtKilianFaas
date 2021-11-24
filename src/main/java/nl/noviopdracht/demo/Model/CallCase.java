package nl.noviopdracht.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CallCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String username;

    String cellnumber;

    long ownerid;

    long carid;

    double price;

    public CallCase(long id, String username, String cellnumber, long ownerid, long carid,double price) {
        this.id = id;
        this.username = username;
        this.cellnumber = cellnumber;
        this.ownerid = ownerid;
        this.carid = carid;
        this.price = price;
    }

    public CallCase() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCellnumber() {
        return cellnumber;
    }

    public void setCellnumber(String cellnumber) {
        this.cellnumber = cellnumber;
    }

    public long getCarid() {
        return carid;
    }

    public void setCarid(long carid) {
        this.carid = carid;
    }

    public long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
