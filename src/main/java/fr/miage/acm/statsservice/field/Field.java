package fr.miage.acm.statsservice.field;

import fr.miage.acm.statsservice.farmer.Farmer;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Field {

    private UUID id;

    private Integer xcoord;
    private Integer ycoord;

    private Farmer farmer;

    public Field(Integer xcoord, Integer ycoord, Farmer farmer) {
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.farmer = farmer;
    }

    public Field() {
        // Default constructor required by JPA
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", xcoord=" + xcoord +
                ", ycoord=" + ycoord +
                ", farmer=" + farmer +
                '}';
    }
}
