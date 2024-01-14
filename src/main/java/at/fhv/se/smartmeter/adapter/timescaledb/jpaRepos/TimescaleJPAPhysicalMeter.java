package at.fhv.se.smartmeter.adapter.timescaledb.jpaRepos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fhv.se.smartmeter.adapter.timescaledb.mapper.PhysicalMeterDBEntity;

public interface TimescaleJPAPhysicalMeter extends JpaRepository<PhysicalMeterDBEntity, UUID> {
    
}
