package at.fhv.se.smartmeter.domain.port.inbound.meterReading;

import java.util.List;

import at.fhv.se.smartmeter.adapter.dto.MeterReadingQueryDTO;

public interface GetMeterReadingForIntervalUseCase {
    List<MeterReadingQueryDTO> getMeterReadingsForInterval(String meterId, String startDate, String endDate);
}
