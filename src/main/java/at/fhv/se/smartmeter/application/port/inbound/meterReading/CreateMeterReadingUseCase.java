package at.fhv.se.smartmeter.application.port.inbound.meterReading;

import at.fhv.se.smartmeter.application.dto.CreateMeterReadingDTO;
import at.fhv.se.smartmeter.application.exceptions.OperationalPropertyNotFoundException;

public interface CreateMeterReadingUseCase {
    String createMeterReading(CreateMeterReadingDTO meterReadingDTO) throws OperationalPropertyNotFoundException;
}
