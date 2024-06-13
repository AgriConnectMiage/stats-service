package fr.miage.acm.statsservice.device;

import fr.miage.acm.statsservice.farmer.Farmer;
import fr.miage.acm.statsservice.field.Field;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Actuator extends Device {

    private Field field;

    public Actuator(Farmer farmer) {
        super(farmer);
        this.field = null;
    }

    public Actuator() {
        // Default constructor required by JPA
    }

    @Override
    public String toString() {
        return "Actuator{" +
                "id=" + getId() +
                ", state=" + getState() +
                ", field=" + getField() +
                ", farmer=" + getFarmer() +
                '}';
    }

    public void setState(DeviceState newState) {
        if ((newState == DeviceState.OFF || newState == DeviceState.ON) && this.getField() == null) {
            throw new IllegalStateException("Cannot change state to " + newState + " of actuator without field");
        }
        if (newState == DeviceState.NOT_ASSIGNED && this.getField() != null) {
            throw new IllegalStateException("Cannot change state to " + newState + " of actuator assigned to a field");
        }
        this.state = newState;
        return;
    }
}
