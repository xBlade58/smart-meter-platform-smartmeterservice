package at.fhv.se.smartmeter.domain.port.inbound.meterReading;

import java.util.List;

import at.fhv.se.smartmeter.domain.model.MeterReading;

public interface GetAllMeterReadingsUseCase {
    List<MeterReading> getAll();
}
