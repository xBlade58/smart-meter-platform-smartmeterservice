package at.fhv.se.smartmeter.application.port.inbound.meter;

public interface AssignHousoldToMeterUseCase {
    void assign(String meterId, String householdId);
}
