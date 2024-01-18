package at.fhv.se.smartmeter.application.port.inbound.meterReading;

import java.util.List;

import at.fhv.se.smartmeter.application.dto.MeterReadingQueryDTO;
import at.fhv.se.smartmeter.application.exceptions.NoMeterForHouseholdException;

public interface GetMeterReadingForIntervalUseCase {
    List<MeterReadingQueryDTO> getMeterReadingsForInterval(String householdId, String startDate, String endDate) throws NoMeterForHouseholdException;
}
