package nl.noviopdracht.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int AccountID;
    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    List<Car> Cars = new ArrayList<>();

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public List<Car> getCars() {
        return Cars;
    }

    public void setCars(List<Car> cars) {
        Cars = cars;
    }
}
