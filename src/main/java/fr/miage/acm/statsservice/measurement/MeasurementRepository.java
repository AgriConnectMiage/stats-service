package fr.miage.acm.statsservice.measurement;


import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;
import java.util.UUID;

public interface MeasurementRepository extends Neo4jRepository<Measurement, UUID> {
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
