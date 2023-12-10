package at.fhv.se.smartmeter.application.port.inbound.meter;

public interface CreateMeterUseCase {
    String createMeter(int serialNumber, String manufacturer);
}
