package at.fhv.se.platform.application.port.inbound.meterReading;

import at.fhv.se.platform.adapter.dto.MeterReadingDTO;

public interface CreateMeterReadingUseCase {
    String createMeterReading(MeterReadingDTO meterReadingDTO);
}
