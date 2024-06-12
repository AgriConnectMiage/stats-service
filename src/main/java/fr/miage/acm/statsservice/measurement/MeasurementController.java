package fr.miage.acm.statsservice.measurement;

import fr.miage.acm.statsservice.api.ApiMeasurement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping
    public List<ApiMeasurement> getAllMeasurements() {
        return measurementService.findAll().stream().map(ApiMeasurement::new).collect(Collectors.toList());
    }

    @GetMapping("/humidity-temperature")
    public ResponseEntity<List<ApiMeasurement>> getByHumidityAndTemperatureNotNull() {
        List<Measurement> measurements = measurementService.getSensorsMeasurements();
        if (measurements.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<ApiMeasurement> apiMeasurements = measurements.stream().map(ApiMeasurement::new).collect(Collectors.toList());
        return ResponseEntity.ok(apiMeasurements);
    }

    @GetMapping("/watering")
    public ResponseEntity<List<ApiMeasurement>> getByWateringDurationNotNull() {
        List<Measurement> measurements = measurementService.getWateringMeasurements();
        if (measurements.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<ApiMeasurement> apiMeasurements = measurements.stream().map(ApiMeasurement::new).collect(Collectors.toList());
        return ResponseEntity.ok(apiMeasurements);
    }

    @GetMapping("/farmer/{farmerId}")
    public ResponseEntity<List<ApiMeasurement>> getByFarmerId(@PathVariable UUID farmerId) {
        List<Measurement> measurements = measurementService.getMeasurementsByFarmer(farmerId);
        if (measurements.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<ApiMeasurement> apiMeasurements = measurements.stream().map(ApiMeasurement::new).collect(Collectors.toList());
        return ResponseEntity.ok(apiMeasurements);
    }

    @GetMapping("/farmer/{farmerId}/humidity-temperature")
    public ResponseEntity<List<ApiMeasurement>> getByFarmerIdAndHumidityAndTemperatureNotNull(@PathVariable UUID farmerId) {
        List<Measurement> measurements = measurementService.getSensorsMeasurementsByFarmer(farmerId);
        if (measurements.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<ApiMeasurement> apiMeasurements = measurements.stream().map(ApiMeasurement::new).collect(Collectors.toList());
        return ResponseEntity.ok(apiMeasurements);
    }

    @GetMapping("/farmer/{farmerId}/watering")
    public ResponseEntity<List<ApiMeasurement>> getByFarmerIdAndWateringDurationNotNull(@PathVariable UUID farmerId) {
        List<Measurement> measurements = measurementService.getWateringMeasurementsByFarmer(farmerId);
        if (measurements.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<ApiMeasurement> apiMeasurements = measurements.stream().map(ApiMeasurement::new).collect(Collectors.toList());
        return ResponseEntity.ok(apiMeasurements);
    }
}
