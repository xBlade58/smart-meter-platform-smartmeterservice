package at.fhv.se.smartmeter.domain.port.inbound.meterReading;

import at.fhv.se.smartmeter.adapter.dto.MeterReadingDTO;

public interface CreateMeterReadingUseCase {
    String createMeterReading(MeterReadingDTO meterReadingDTO);
}
