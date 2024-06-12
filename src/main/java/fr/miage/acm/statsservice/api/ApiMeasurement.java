package fr.miage.acm.statsservice.api;

import fr.miage.acm.statsservice.measurement.Measurement;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ApiMeasurement {

    private UUID id;

    private LocalDateTime dateTime;

    private UUID farmerId;
    private String fieldCoord;
    private UUID deviceId;

    private Float humidity;
    private Float temperature;
    private Float wateringDuration;

    public ApiMeasurement(Measurement measurement) {
        this.id = measurement.getId();
        this.dateTime = measurement.getDateTime();
        this.farmerId = measurement.getFarmerId();
        this.fieldCoord = measurement.getFieldCoord();
        this.deviceId = measurement.getDeviceId();
        this.humidity = measurement.getHumidity();
        this.temperature = measurement.getTemperature();
        this.wateringDuration = measurement.getWateringDuration();
    }
}
