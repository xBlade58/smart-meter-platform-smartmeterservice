package at.fhv.se.smartmeter.adapter.timescaledb;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fhv.se.smartmeter.model.Meter;

public interface TimescaleJPAMeter extends JpaRepository<Meter, Integer> {
    
}
