package nl.noviopdracht.demo.DTO;



public class RepairDTO {

    long repID;

    float carID;

    boolean repairComfirm = false;

    boolean paymentComfirm = false;

    boolean agree_on_repiar = false;

    String pickUpDate;


    public RepairDTO(long repID,float carID, boolean repairComfirm, boolean paymentComfirm
    ) {
        this.repID = repID;
        this.carID = carID;
        this.repairComfirm = repairComfirm;
        this.paymentComfirm = paymentComfirm;
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
