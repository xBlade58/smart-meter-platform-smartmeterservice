package at.fhv.se.platform.application.port.inbound.meterReading;

import at.fhv.se.platform.adapter.rest.dto.MeterReadingDTO;

public interface CreateMeterReadingUseCase {
    String createMeterReading(MeterReadingDTO meterReadingDTO);
}
