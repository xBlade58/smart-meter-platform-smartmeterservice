package at.fhv.se.smartmeter.application.port.inbound.meter;

public interface CreateMeterUseCase {
    String createMeter(String serialNumber, String physicalMeterId);
}
