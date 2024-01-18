package at.fhv.se.smartmeter.application.port.inbound.meter;

public interface UnassignHouseholdFromMeterUseCase {
    void unassign(String meterId);    
}
