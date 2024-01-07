package at.fhv.se.smartmeter.domain.port.inbound.meter;

public interface CreateMeterUseCase {
    String createMeter(String serialNumber, String physicalMeterId);
}
