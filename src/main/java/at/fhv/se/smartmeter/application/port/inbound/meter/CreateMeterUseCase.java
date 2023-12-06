package at.fhv.se.smartmeter.application.port.inbound.meter;

public interface CreateMeterUseCase {
    long createMeter(int serialNumber, String manufacturer);
}
