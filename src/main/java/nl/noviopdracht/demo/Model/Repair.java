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

    @ManyToOne()
    @JoinColumn(name = "repairing_car")
    private Car car;

    boolean repairComfirm = false;

    boolean paymentComfirm = false;

    boolean agree_on_repiar = false;

    String pickUpDate;

    public Repair(Car car, boolean repairComfirm, boolean paymentComfirm
    ) {
        this.car = car;
        this.repairComfirm = repairComfirm;
        this.paymentComfirm = paymentComfirm;
    }

    public Repair(long repID, Car car, boolean repairComfirm, boolean paymentComfirm, boolean agree_on_repiar, String pickUpDate) {
        this.repID = repID;
        this.car = car;
        this.repairComfirm = repairComfirm;
        this.paymentComfirm = paymentComfirm;
        this.agree_on_repiar = agree_on_repiar;
        this.pickUpDate = pickUpDate;
    }

    public Repair() {

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

    public boolean isRepairComfirm() {
        return repairComfirm;
    }

    public void setRepairComfirm(boolean repairComfirm) {
        this.repairComfirm = repairComfirm;
    }

    public boolean isPaymentComfirm() {
        return paymentComfirm;
    }

    public void setPaymentComfirm(boolean paymentComfirm) {
        this.paymentComfirm = paymentComfirm;
    }

    public void setRepID(long repID) {
        this.repID = repID;
    }

    public boolean isAgree_on_repiar() {
        return agree_on_repiar;
    }

    public void setAgree_on_repiar(boolean agree_on_repiar) {
        this.agree_on_repiar = agree_on_repiar;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }
}
