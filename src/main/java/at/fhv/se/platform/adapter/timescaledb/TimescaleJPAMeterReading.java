package at.fhv.se.platform.adapter.timescaledb;


import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fhv.se.platform.model.MeterReading;

public interface TimescaleJPAMeterReading extends JpaRepository<MeterReading, Timestamp> {
    
}
