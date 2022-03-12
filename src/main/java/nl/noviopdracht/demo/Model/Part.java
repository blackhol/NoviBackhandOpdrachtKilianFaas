package nl.noviopdracht.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "You need to fill in a name for the part" )
    private String partname;

    @NotNull(message = "you need to fill in a price for the part")
    private float price;

    @NotNull(message = "you need to fill in a amount for the part")
    private int amount;

    //Constructor
    public Part(String partname, float price, int amount) {
        this.partname = partname;
        this.price = price;
        this.amount = amount;
    }

    public Part() {

    }

    // getters setters


    public long getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPartname() {
        return partname;
    }

    public void setPartname(String partname) {
        this.partname = partname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }



}
