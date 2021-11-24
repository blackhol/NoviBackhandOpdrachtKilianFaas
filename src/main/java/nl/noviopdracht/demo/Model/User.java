package nl.noviopdracht.demo.Model;

import org.springframework.expression.spel.ast.Operator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "You need to fill in a name")
    private String name;

    @NotBlank(message = "You need to fill in a email")
    private String email;

    @NotBlank(message = "You need to fill in a password")
    private String password;

    private String note;

    private Date birthday;

    @OneToMany(mappedBy = "owner")
    private List<Car> ownedCars;

    private String cellnumber;
    
    private String profession;

    public User( String name, String email, String password, String note, Date birthday, List<Car> ownedCars, String cellnumber, String profession) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.note = note;
        this.birthday = birthday;
        this.ownedCars = ownedCars;
        this.cellnumber = cellnumber;
        this.profession = profession;
    }

    public User() {

    }

    public User(String name, String email, String password, String note, Date birthday, String cellnumber, String profession) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.note = note;
        this.birthday = birthday;
        this.cellnumber = cellnumber;
        this.profession = profession;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", note='" + note + '\'' +
                ", birthday=" + birthday +
                ", profession='" + profession + '\'' +
                '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<Car> getOwnedCars() {
        return ownedCars;
    }

    public void setOwnedCars(List<Car> ownedCars) {
        this.ownedCars = ownedCars;
    }

    public String getCellnumber() {
        return cellnumber;
    }

    public void setCellnumber(String cellnumber) {
        this.cellnumber = cellnumber;
    }
}