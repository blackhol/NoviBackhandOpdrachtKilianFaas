package nl.noviopdracht.demo.DTO;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class RepairDTO {

    @NotNull
    int repID;

    @NotNull
    int carID;

    boolean repairComfirm = false;

    ArrayList<Integer> usedparts = new ArrayList<Integer>();

    String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getRepID() {
        return repID;
    }

    public void setRepID(int repID) {
        this.repID = repID;
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

    public ArrayList<Integer> getUsedparts() {
        return usedparts;
    }

    public void setUsedparts(ArrayList<Integer> usedparts) {
        this.usedparts = usedparts;
    }

    public RepairDTO(int carID, boolean repairComfirm, ArrayList<Integer> usedparts , String notes) {
        this.carID = carID;
        this.repairComfirm = repairComfirm;
        this.usedparts = usedparts;
        this.notes = notes;
    }

    public RepairDTO() {
    }
}
