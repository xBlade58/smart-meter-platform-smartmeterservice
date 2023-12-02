package at.fhv.se.platform.application.port.inbound.meterReading;

import java.util.List;

import at.fhv.se.platform.model.MeterReading;

public interface GetAllMeterReadingsUseCase {
    List<MeterReading> getAll();
}
