package nl.noviopdracht.demo.DTO;

import nl.noviopdracht.demo.Model.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class CarDTO {

    long  carID;

    @NotNull
    long ownerID;

    @ManyToOne()
    @JoinColumn(name = "owner")
    private User owner;

    String carBrand;

    String licencePlate;

    public CarDTO() {
    }

    public CarDTO(User owner, String carBrand, String licencePlate, long ownerID) {
        this.owner = owner;
        this.carBrand = carBrand;
        this.licencePlate = licencePlate;
        this.ownerID = ownerID;
    }
    public CarDTO(long carID,String carBrand, String licencePlate){

    }

    public CarDTO(long carID, String licencePlate) {
    }



    public long getCarID() {
        return carID;
    }

    public void setCarID(long carID) {
        this.carID = carID;
    }

    public long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(long ownerID) {
        this.ownerID = ownerID;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }


}
