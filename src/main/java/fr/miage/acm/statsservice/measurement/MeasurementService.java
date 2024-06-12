package fr.miage.acm.statsservice.measurement;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MeasurementService {

    private MeasurementRepository measurementRepository;

    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    // get all measurements
    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    // get measurements



}
