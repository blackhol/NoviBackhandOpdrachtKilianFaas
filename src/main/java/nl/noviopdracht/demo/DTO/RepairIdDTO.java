package nl.noviopdracht.demo.DTO;

public class RepairIdDTO {
    long repairID;

    public RepairIdDTO(long repairID) {
        this.repairID = repairID;
    }

    public RepairIdDTO() {
    }

    public long getRepairID() {
        return repairID;
    }

    public void setRepairID(long repairID) {
        this.repairID = repairID;
    }
}
