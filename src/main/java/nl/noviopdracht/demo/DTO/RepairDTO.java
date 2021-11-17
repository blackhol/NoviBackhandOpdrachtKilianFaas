package nl.noviopdracht.demo.DTO;

import nl.noviopdracht.demo.Model.OrderItem;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class RepairDTO {

    long repID;

    float carID;

    boolean repairComfirm = false;

    boolean paymentComfirm = false;

//    ArrayList<Long> usedpartID = new ArrayList<Long>();


    public RepairDTO(long repID,float carID, boolean repairComfirm, boolean paymentComfirm
//            ,ArrayList<Long> usedpartID
    ) {
        this.repID = repID;
        this.carID = carID;
        this.repairComfirm = repairComfirm;
        this.paymentComfirm = paymentComfirm;
//        this.usedpartID = usedpartID;
    }

    public RepairDTO() {
    }

    public long getRepID() {
        return repID;
    }

    public void setRepID(long repID) {
        this.repID = repID;
    }

    public float getCarID() {
        return carID;
    }

    public void setCarID(float carID) {
        this.carID = carID;
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

//    public ArrayList<Long> getUsedpartID() {
//        return usedpartID;
//    }
//
//    public void setUsedpartID(ArrayList<Long> usedpartID) {
//        this.usedpartID = usedpartID;
//    }
}
