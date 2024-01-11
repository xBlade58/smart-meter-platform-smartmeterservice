package at.fhv.se.smartmeter.domain.port.inbound.meterReading;

import java.util.List;

import at.fhv.se.smartmeter.adapter.dto.MeterReadingDTO;

public interface GetMeterReadingForIntervalUseCase {
    List<MeterReadingDTO> getMeterReadings(String startDate, String endDate);
}
