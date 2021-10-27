package nl.noviopdracht.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int repID;

    @NotNull
    int carID;

    @ManyToOne()
    @JoinColumn(name = "repairing_car")
    private Car car;

    boolean repairComfirm = false;



    String notes;

    public Repair( int carID, boolean repairComfirm, String notes) {
        this.carID = carID;
        this.repairComfirm = repairComfirm;
        this.notes = notes;
    }

    public Repair() {

    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public boolean isRepairComfirm() {
        return repairComfirm;
    }

    public void setRepairComfirm(boolean repairComfirm) {
        this.repairComfirm = repairComfirm;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String note) {
        this.notes = note;
    }
}
