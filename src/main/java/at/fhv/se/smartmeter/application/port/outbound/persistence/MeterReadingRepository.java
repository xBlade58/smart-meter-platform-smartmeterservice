package at.fhv.se.smartmeter.application.port.outbound.persistence;

import java.time.ZonedDateTime;
import java.util.List;

import at.fhv.se.smartmeter.domain.MeterReading;


public interface MeterReadingRepository {
    String nextIdentity();
    String save(MeterReading mr);
    List<MeterReading> getAllMeterReadings();
    List<MeterReading> getMeterReadingsForInterval(String meterId, ZonedDateTime start, ZonedDateTime end);
}
