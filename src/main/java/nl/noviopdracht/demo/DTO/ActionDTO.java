package nl.noviopdracht.demo.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ActionDTO {

    Long ActionId;

    @NotBlank
    String name;

    @NotNull
    int price;

    public ActionDTO(Long ActionId, String name, int price) {
        this.ActionId = ActionId;
        this.name = name;
        this.price = price;
    }

    public ActionDTO() {
    }

    public Long getActionId() {
        return ActionId;
    }

    public void getActionId(Long serviceInt) {
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
