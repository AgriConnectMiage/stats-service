package fr.miage.acm.statsservice.measurement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MeasurementRepository extends JpaRepository<Measurement, UUID> {
    // Get sensors measurements
    List<Measurement> findByHumidityIsNotNullAndTemperatureIsNotNull();

    // Get watering measurements
    List<Measurement> findByWateringDurationIsNotNull();

    List<Measurement> findByFarmerId(UUID farmerId);

    // Get sensors measurements by farmerId
    List<Measurement> findByFarmerIdAndHumidityIsNotNullAndTemperatureIsNotNull(UUID farmerId);

    // Get watering measurements by farmerId
    List<Measurement> findByFarmerIdAndWateringDurationIsNotNull(UUID farmerId);
}
