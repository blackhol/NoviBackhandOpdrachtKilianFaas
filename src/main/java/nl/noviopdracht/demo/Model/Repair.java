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

//    ArrayList<Long> usedpartID = new ArrayList<Long>();

    public Repair(Car car, boolean repairComfirm, boolean paymentComfirm
//            , ArrayList<Long> usedpartID
    ) {
        this.car = car;
        this.repairComfirm = repairComfirm;
        this.paymentComfirm = paymentComfirm;
//        this.usedpartID = usedpartID;
    }

    public Repair() {

    }

    public Repair(float carID, boolean repairComfirm, boolean paymentComfirm, String notes, ArrayList<OrderItem> useditems) {
    }

//    public Repair(Car byId, boolean repairComfirm, boolean paymentComfirm, String notes, ArrayList<Long> usedpartID) {
//    }

    public float getRepID() {
        return repID;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

//    public ArrayList<Long> getUsedpartID() {
//        return usedpartID;
//    }
//
//    public void setUsedpartID(ArrayList<Long> usedpartID) {
//        this.usedpartID = usedpartID;
//    }

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
}
