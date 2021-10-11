package nl.noviopdracht.demo;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long CarID ;
    String name;
    String LicensePlate;
    int OwnerID;

    @ManyToOne()
    Account account;


    public Long getCarID() {
        return CarID;
    }

    public void setCarID(Long carID) {
        CarID = carID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
    }

    public int getOwnerID() {
        return OwnerID;
    }

    public void setOwnerID(int ownerID) {
        OwnerID = ownerID;
    }
}
