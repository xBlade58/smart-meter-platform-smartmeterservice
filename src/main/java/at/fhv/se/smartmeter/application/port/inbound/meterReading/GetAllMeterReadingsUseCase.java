package at.fhv.se.smartmeter.application.port.inbound.meterReading;

import java.util.List;

import at.fhv.se.smartmeter.model.MeterReading;

public interface GetAllMeterReadingsUseCase {
    List<MeterReading> getAll();
}
