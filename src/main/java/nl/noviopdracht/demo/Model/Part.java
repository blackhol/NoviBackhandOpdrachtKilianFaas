package nl.noviopdracht.demo.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "You need to fill in a name for the part" )
    private String partname;

    @NotNull(message = "you need to fill in a price for the part")
    private float price;


    // getters setters
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
    //Constructor

    public Part(String partname, float price) {
        this.partname = partname;
        this.price = price;
    }

    public Part() {
    }
}
