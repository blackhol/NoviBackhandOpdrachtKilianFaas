package nl.noviopdracht.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int carID;
    @NotNull
    int OwnerID;
    @NotBlank
    String carBrand;
    @NotBlank
    String licencePlate;

    String notes;

    public int getUserID() {
        return OwnerID;
    }

    public void setUserID(int userID) {
        OwnerID = userID;
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

    public Car() {
    }

    public Car(int userID, String carBrand, String licencePlate, String notes) {
        OwnerID = userID;
        this.carBrand = carBrand;
        this.licencePlate = licencePlate;
        this.notes = notes;
    }

}
