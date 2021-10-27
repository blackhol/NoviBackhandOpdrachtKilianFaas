package nl.noviopdracht.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int carID;

    @ManyToOne()
    @JoinColumn(name = "owner")
    private User owner;


    @NotBlank
    String carBrand;

    @NotBlank
    String licencePlate;

    String notes;

    @OneToMany(mappedBy = "car")
    private List<Repair> repairsOnCar;

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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Car() {
    }

    public Car(User user, String carBrand, String licencePlate) {
        this.owner = user;
        this.carBrand = carBrand;
        this.licencePlate = licencePlate;
    }

}
