package nl.noviopdracht.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ActionId;

    @NotBlank
    String name;

    @NotBlank
    int price;

    public Action(Long ActionId, String name, int price) {
        this.ActionId = ActionId;
        this.name = name;
        this.price = price;
    }

    public Action() {
    }

    public Long getActionInt() {
        return ActionId;
    }

    public void setActionInt(Long serviceInt) {
        this.ActionId = serviceInt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
