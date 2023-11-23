package at.fhv.se.platform.application;

import at.fhv.se.platform.dto.MeterReadingDTO;

import java.util.List;

/**
 * @author Justin Ströhle
 * 23.11.2023
 */

public interface MeterReadingService {
    String createMeterReading(MeterReadingDTO meterReadingDTO);
    List<MeterReadingDTO> getAllMeterReadings();
}
