package nl.noviopdracht.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int carID;

    @ManyToOne()
    @JoinColumn(name = "owner")
    private User owner;


    String carBrand;

    String licencePlate;



    public Car() {
    }

    public Car(User owner, String carBrand, String licencePlate) {
        this.owner = owner;
        this.carBrand = carBrand;
        this.licencePlate = licencePlate;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getCarID() {
        return carID;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
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
