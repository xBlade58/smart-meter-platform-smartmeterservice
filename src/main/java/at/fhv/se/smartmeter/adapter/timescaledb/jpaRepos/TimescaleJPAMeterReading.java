package at.fhv.se.smartmeter.adapter.timescaledb.jpaRepos;


import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import at.fhv.se.smartmeter.adapter.timescaledb.model.MeterReadingDBEntity;

public interface TimescaleJPAMeterReading extends JpaRepository<MeterReadingDBEntity, UUID> {
    
    @Query("SELECT mr FROM MeterReadingDBEntity mr " +
            "WHERE mr.meterDBEntity.id = :meterId " +
            "AND mr.readingTime BETWEEN :start AND :end")
    List<MeterReadingDBEntity> findByReadingTimeBetween(@Param("meterId") UUID meterId,
        @Param("start") ZonedDateTime start, @Param("end") ZonedDateTime end);

}
