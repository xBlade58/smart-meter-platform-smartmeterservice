package at.fhv.se.smartmeter.adapter.timescaledb;


import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fhv.se.smartmeter.model.MeterReading;

public interface TimescaleJPAMeterReading extends JpaRepository<MeterReading, Timestamp> {
    
}
