package at.fhv.se.smartmeter.adapter.timescaledb;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fhv.se.smartmeter.adapter.timescaledb.mapper.MeterReadingDBEntity;

public interface TimescaleJPAMeterReading extends JpaRepository<MeterReadingDBEntity, UUID> {
    
}
