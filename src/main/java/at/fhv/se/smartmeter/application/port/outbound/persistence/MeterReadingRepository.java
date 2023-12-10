package at.fhv.se.smartmeter.application.port.outbound.persistence;

import java.util.List;

import at.fhv.se.smartmeter.model.MeterReading;

/**
 * @author Justin Ströhle
 * 23.11.2023
 */

 // outbonnd port
public interface MeterReadingRepository {
    void save(MeterReading mr);
    List<MeterReading> getAllMeterReadings();
}
