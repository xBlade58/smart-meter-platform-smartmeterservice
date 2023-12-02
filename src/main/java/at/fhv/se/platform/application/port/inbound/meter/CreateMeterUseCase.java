package at.fhv.se.platform.application.port.inbound.meter;

public interface CreateMeterUseCase {
    int createMeter(int id, String manufacturer);
}
