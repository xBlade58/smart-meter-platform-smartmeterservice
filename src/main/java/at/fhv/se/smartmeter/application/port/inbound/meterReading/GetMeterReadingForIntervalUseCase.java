package at.fhv.se.smartmeter.application.port.inbound.meterReading;

import java.util.List;

import at.fhv.se.smartmeter.application.dto.MeterReadingQueryDTO;

public interface GetMeterReadingForIntervalUseCase {
    List<MeterReadingQueryDTO> getMeterReadingsForInterval(String meterId, String startDate, String endDate);
}
