package at.fhv.se.smartmeter.adapter.timescaledb.jpaRepos;

import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fhv.se.smartmeter.adapter.timescaledb.model.MeterDBEntity;

public interface TimescaleJPAMeter extends JpaRepository<MeterDBEntity, UUID> {

}
