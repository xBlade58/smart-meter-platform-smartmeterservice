package at.fhv.se.platform.application.port.outbound.persistence;

import java.util.List;

import at.fhv.se.platform.model.MeterReading;

/**
 * @author Justin Ströhle
 * 23.11.2023
 */

 // outbonnd port
public interface MeterReadingRepository {
    void save(MeterReading mr);
    List<MeterReading> getAllMeterReadings();
}
