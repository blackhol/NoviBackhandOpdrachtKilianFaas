package nl.noviopdracht.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long repID;

    long carID;

    @ManyToOne()
    @JoinColumn(name = "repairing_car")
    private Car car;

    boolean repairComfirm = false;

    boolean paymentComfirm = false;

    String notes;

    @OneToMany(mappedBy = "repair")
    List<OrderItem> useditems;


    public Repair(Car car, boolean repairComfirm, boolean paymentComfirm, String notes, ArrayList<OrderItem> useditems) {
        this.car = car;
        this.repairComfirm = repairComfirm;
        this.paymentComfirm = paymentComfirm;
        this.notes = notes;
        this.useditems = useditems;
    }

    public Repair() {

    }

    public Repair(float carID, boolean repairComfirm, boolean paymentComfirm, String notes, ArrayList<OrderItem> useditems) {
    }

    public float getRepID() {
        return repID;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<OrderItem> getUseditems() {
        return useditems;
    }

    public void setUseditems(List<OrderItem> useditems) {
        this.useditems = useditems;
    }

    public float getCarID() {
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

    public boolean isPaymentComfirm() {
        return paymentComfirm;
    }

    public void setPaymentComfirm(boolean paymentComfirm) {
        this.paymentComfirm = paymentComfirm;
    }
}
