package nl.noviopdracht.demo.Model;

import javax.persistence.*;

@Entity
public class RegisterItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    String name;

    double price;

    public RegisterItem(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public RegisterItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
