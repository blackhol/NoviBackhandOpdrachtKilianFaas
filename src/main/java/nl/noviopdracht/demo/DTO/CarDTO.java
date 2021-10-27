package nl.noviopdracht.demo.DTO;

import net.bytebuddy.implementation.bind.annotation.Default;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class CarDTO {

    @NotNull
    long ownerID;
    @NotBlank
    String carBrand;
    @NotBlank
    String licencePlate;

    String notes;


    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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


    public CarDTO() {
    }

    public CarDTO(int userID, String carBrand,String licencePlate, String notes) {
        ownerID = userID;
        this.notes = notes;
        this.carBrand = carBrand;
        this.licencePlate = licencePlate;

    }
}
