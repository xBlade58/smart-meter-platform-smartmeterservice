package at.fhv.se.smartmeter.application.port.inbound.meterReading;

import at.fhv.se.smartmeter.application.dto.CreateMeterReadingDTO;

public interface CreateMeterReadingUseCase {
    String createMeterReading(CreateMeterReadingDTO meterReadingDTO);
}
