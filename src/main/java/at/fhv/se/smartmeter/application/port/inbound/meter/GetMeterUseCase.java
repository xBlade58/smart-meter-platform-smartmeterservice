package at.fhv.se.smartmeter.application.port.inbound.meter;

import at.fhv.se.smartmeter.application.dto.MeterDTO;

public interface GetMeterUseCase {
    MeterDTO getById(String id);
    boolean existsById(String id);
}
