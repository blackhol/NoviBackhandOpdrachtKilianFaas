package nl.noviopdracht.demo.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CarDTO {

    @NotNull
    int OwnerID;
    @NotBlank
    String carBrand;
    @NotBlank
    String licencePlate;

    String notes;

    public int getOwnerID() {
        return OwnerID;
    }

    public void setOwnerID(int ownerID) {
        OwnerID = ownerID;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public CarDTO() {
    }

    public CarDTO(int userID, String carBrand,String licencePlate,String notes) {
        OwnerID = userID;
        this.carBrand = carBrand;
        this.licencePlate = licencePlate;
        this.notes = notes;
    }
}
