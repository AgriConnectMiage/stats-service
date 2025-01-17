package fr.miage.acm.statsservice.farmer;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Farmer {

    private UUID id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer fieldSize;

    public Farmer(String firstName, String lastName, String email, String password, int fieldSize) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.fieldSize = fieldSize;
    }

    public Farmer() {
        // Default constructor required by JPA
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fieldSize=" + fieldSize +
                '}';
    }
}
