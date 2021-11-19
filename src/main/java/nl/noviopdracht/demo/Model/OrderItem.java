package nl.noviopdracht.demo.Model;

import javax.persistence.*;

@Entity
public class OrderItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id ;


    long repairID;

    long partId;

    long actionId;

    float price;

    public OrderItem(long repairID, long partId, float price) {
        this.repairID = repairID;
        this.partId = partId;
        this.price = price;
    }
    public OrderItem() {

    }

    public OrderItem(Long partId, float price, long repairID,Long actionId) {
        this.partId = partId;
        this.price = price;
        this.repairID = repairID;
        this.actionId = actionId;
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
