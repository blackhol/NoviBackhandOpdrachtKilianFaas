package nl.noviopdracht.demo;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id ;
    String name;
    String Postalcode;

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPostalcode(String postalcode) {
        Postalcode = postalcode;
    }

}

