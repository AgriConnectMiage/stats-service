package fr.miage.acm.statsservice.measurement;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    // Get all measurements
    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    // Get measurements with humidity and temperature
    public List<Measurement> getSensorsMeasurements() {
        return measurementRepository.findByHumidityIsNotNullAndTemperatureIsNotNull();
    }

    // Get measurements with watering duration
    public List<Measurement> getWateringMeasurements() {
        return measurementRepository.findByWateringDurationIsNotNull();
    }

    // Get measurements by farmerId
    public List<Measurement> getMeasurementsByFarmer(UUID farmerId) {
        return measurementRepository.findByFarmerId(farmerId);
    }

    // Get measurements by farmerId with humidity and temperature
    public List<Measurement> getSensorsMeasurementsByFarmer(UUID farmerId) {
        return measurementRepository.findByFarmerIdAndHumidityIsNotNullAndTemperatureIsNotNull(farmerId);
    }

    // Get measurements by farmerId with watering duration
    public List<Measurement> getWateringMeasurementsByFarmer(UUID farmerId) {
        return measurementRepository.findByFarmerIdAndWateringDurationIsNotNull(farmerId);
    }
}
