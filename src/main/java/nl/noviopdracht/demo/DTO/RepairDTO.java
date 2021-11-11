package nl.noviopdracht.demo.DTO;

import nl.noviopdracht.demo.Model.OrderItem;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class RepairDTO {

    @NotNull
    long repID;

    @NotNull
    float carID;

    boolean repairComfirm = false;

    boolean paymentComfirm = false;

    ArrayList<OrderItem> useditems = new ArrayList<OrderItem>();

    String notes;


    public RepairDTO(float carID, boolean repairComfirm, ArrayList<OrderItem> useditems , String notes, boolean paymentComfirm) {
        this.carID = carID;
        this.repairComfirm = repairComfirm;
        this.useditems = useditems;
        this.notes = notes;
        this.paymentComfirm = paymentComfirm;
    }

    public RepairDTO() {
    }



    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public float getRepID() {
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

    public ArrayList<OrderItem> getUseditems() {
        return useditems;
    }

    public void setUseditems(ArrayList<OrderItem> useditems) {
        this.useditems = useditems;
    }

    public boolean isPaymentComfirm() {
        return paymentComfirm;
    }

    public void setPaymentComfirm(boolean paymentComfirm) {
        this.paymentComfirm = paymentComfirm;
    }
}
