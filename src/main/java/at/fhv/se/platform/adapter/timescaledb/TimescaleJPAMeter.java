package at.fhv.se.platform.adapter.timescaledb;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fhv.se.platform.model.Meter;

public interface TimescaleJPAMeter extends JpaRepository<Meter, Integer> {
    
}
