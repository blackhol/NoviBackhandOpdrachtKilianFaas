package nl.noviopdracht.demo.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class PartDTO {

    private Long id;

    @NotBlank(message = "You need to fill in a name for the part" )
    private String partname;

    @NotNull(message = "you need to fill in a price for the part")
    private float price;

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

    public PartDTO() {

    }

    public PartDTO(Long id, String partname, float price) {
        this.id = id;
        this.partname = partname;
        this.price = price;
    }

    @Override
    public String toString() {
        return "PartDTO{" +
                "partname='" + partname + '\'' +
                ", price=" + price +
                '}';
    }
}
