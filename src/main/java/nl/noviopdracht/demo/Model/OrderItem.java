package nl.noviopdracht.demo.Model;

import javax.persistence.*;

@Entity
public class OrderItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    float id ;

    @ManyToOne
    @JoinColumn(name = "useditems")
    Repair repair;

    float repairId;

    float partId;

    float actionId;



    enum Ordertype {
        part,
        action
    }

    float price;

    int quantity;

    public OrderItem(Repair repair, float repairId, float partId, float actionId, float price, int quantity) {
        this.repair = repair;
        this.repairId = repairId;
        this.partId = partId;
        this.actionId = actionId;
        this.price = price;
        this.quantity = quantity;
    }
    public OrderItem() {

    }

    public float getId() {
        return id;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public float getRepairId() {
        return repairId;
    }

    public void setRepairId(float repairId) {
        this.repairId = repairId;
    }

    public float getPartId() {
        return partId;
    }

    public void setPartId(float partId) {
        this.partId = partId;
    }

    public float getActionId() {
        return actionId;
    }

    public void setActionId(float actionId) {
        this.actionId = actionId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
