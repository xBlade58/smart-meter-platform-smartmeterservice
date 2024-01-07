package at.fhv.se.smartmeter.domain.port.outbound.persistence;

import java.util.List;

import at.fhv.se.smartmeter.domain.model.MeterReading;


public interface MeterReadingRepository {
    String save(MeterReading mr);
    List<MeterReading> getAllMeterReadings();
}
