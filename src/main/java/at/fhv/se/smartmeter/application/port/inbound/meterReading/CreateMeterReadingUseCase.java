package at.fhv.se.smartmeter.application.port.inbound.meterReading;

import at.fhv.se.smartmeter.application.dto.MeterReadingDTO;

public interface CreateMeterReadingUseCase {
    String createMeterReading(MeterReadingDTO meterReadingDTO);
}
