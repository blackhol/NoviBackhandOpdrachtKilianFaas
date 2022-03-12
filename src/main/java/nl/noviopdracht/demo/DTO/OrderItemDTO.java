package nl.noviopdracht.demo.DTO;

import nl.noviopdracht.demo.Model.Repair;

import javax.persistence.*;

public class OrderItemDTO {

    long id ;

    long repairID;

    long partId;

    long actionId;

    float price;

    public OrderItemDTO(long repairID, long partId, long actionId, float price) {
        this.repairID = repairID;
        this.partId = partId;
        this.actionId = actionId;
        this.price = price;
    }


    public OrderItemDTO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRepairID() {
        return repairID;
    }

    public void setRepairID(long repairID) {
        this.repairID = repairID;
    }

    public long getPartId() {
        return partId;
    }

    public void setPartId(long partId) {
        this.partId = partId;
    }

    public long getActionId() {
        return actionId;
    }

    public void setActionId(long actionId) {
        this.actionId = actionId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
