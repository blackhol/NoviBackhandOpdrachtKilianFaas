package nl.noviopdracht.demo.Model;

import org.hibernate.annotations.Cascade;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long carID;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "owner")
    private User owner;

    Long ownerID;

    @OneToMany()
    @JoinColumn(name = "repair")
    private List<Repair> repairs;

    String carBrand;

    String licencePlate;

    @Transient
    private List<MultipartFile> files = new ArrayList<MultipartFile>();

    @Transient
    private List<String> removeImages = new ArrayList<String>();

    public Car() {
    }

    public Car(User owner, String carBrand, String licencePlate) {
        this.owner = owner;
        this.carBrand = carBrand;
        this.licencePlate = licencePlate;
    }

    public Car(User owner, Long ownerID, String carBrand, String licencePlate) {
        this.owner = owner;
        this.ownerID = ownerID;
        this.carBrand = carBrand;
        this.licencePlate = licencePlate;
    }

    public long getCarID() {
        return carID;
    }

    public void setCarID(long carID) {
        this.carID = carID;
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

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }

    public List<String> getRemoveImages() {
        return removeImages;
    }

    public void setRemoveImages(List<String> removeImages) {
        this.removeImages = removeImages;
    }

    public Long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Long ownerID) {
        this.ownerID = ownerID;
    }
}
