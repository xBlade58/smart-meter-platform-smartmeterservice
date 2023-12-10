package at.fhv.se.smartmeter.adapter.timescaledb;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fhv.se.smartmeter.adapter.timescaledb.mapper.MeterDBEntity;

public interface TimescaleJPAMeter extends JpaRepository<MeterDBEntity, Integer> {
    
}
