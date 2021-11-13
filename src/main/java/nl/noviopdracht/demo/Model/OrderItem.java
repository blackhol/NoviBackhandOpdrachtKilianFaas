package nl.noviopdracht.demo.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrderItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id ;

    @ManyToOne
    @JoinColumn(name = "useditems")
    Repair repair;

    long partId;

    long actionId;

    float price;

    public OrderItem(Repair repair, long partId, float price) {
        this.repair = repair;
        this.partId = partId;
        this.price = price;
    }
    public OrderItem() {

    }

    public OrderItem(Long partId, float price) {
        this.partId = partId;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
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
