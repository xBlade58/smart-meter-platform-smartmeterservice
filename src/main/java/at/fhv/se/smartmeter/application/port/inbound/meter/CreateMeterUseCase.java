package at.fhv.se.smartmeter.application.port.inbound.meter;

public interface CreateMeterUseCase {
    int createMeter(int id, String manufacturer);
}