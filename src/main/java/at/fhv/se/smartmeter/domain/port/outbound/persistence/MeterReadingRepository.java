package at.fhv.se.smartmeter.domain.port.outbound.persistence;

import java.time.ZonedDateTime;
import java.util.List;

import at.fhv.se.smartmeter.domain.model.MeterReading;


public interface MeterReadingRepository {
    String nextIdentity();
    String save(MeterReading mr);
    List<MeterReading> getAllMeterReadings();
    List<MeterReading> getMeterReadingsForInterval(String meterId, ZonedDateTime start, ZonedDateTime end);
}
