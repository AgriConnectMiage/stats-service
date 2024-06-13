package fr.miage.acm.statsservice.measurement;

import fr.miage.acm.statsservice.device.Device;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Node("Measurement")
public class Measurement {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDateTime dateTime;
    private UUID farmerId;
    private String fieldCoord;
    private UUID deviceId;
    private Float humidity;
    private Float temperature;
    private Float wateringDuration;

    public Measurement(UUID id, LocalDateTime dateTime, Device device, Float humidity, Float temperature, Float wateringDuration) {
        this.id = id != null ? id : UUID.randomUUID();
        this.dateTime = dateTime;
        this.deviceId = device.getId();
        this.farmerId = device.getFarmer().getId();
        this.humidity = humidity;
        this.temperature = temperature;
        this.wateringDuration = wateringDuration;
    }

    public Measurement() {
        // Default constructor required by Neo4j
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", deviceId=" + deviceId +
                ", humidity=" + humidity +
                ", temperature=" + temperature +
                ", wateringDuration=" + wateringDuration +
                '}';
    }
}