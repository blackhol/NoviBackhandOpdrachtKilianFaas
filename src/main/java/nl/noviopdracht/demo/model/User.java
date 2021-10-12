package nl.noviopdracht.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

    @Entity
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
    @NotBlank(message = "You need to fill in a name")
    private String name;

    @NotBlank(message = "You need to fill in a email")
    private String email;

    @NotBlank(message = "You need to fill in a password")
    private String password;

    private String note;

    private Date birthday;


    private String profession;

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

        public User( String name, String email, String password, String note, Date birthday, String profession) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.note = note;
            this.birthday = birthday;
            this.profession = profession;
        }

        public User() {

        }
    }