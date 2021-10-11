package nl.noviopdracht.demo;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class PersonDTO {

    @NotNull(message = "Name cannot be empty")
    @Size(min = 3, max = 128)
    private String name;

    @NotNull(message = "Email cannot be empty")
    @Email
    private String email;

    @NotNull(message = "Postalcode cannot be empty")
    @Size(min = 6, max = 7)
    private String postalcode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getEmail() {
        return email;


    }

    public void setEmail(String email) {
        this.email = email;
    }
}
