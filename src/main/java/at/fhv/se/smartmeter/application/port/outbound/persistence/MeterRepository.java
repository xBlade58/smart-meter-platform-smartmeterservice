package at.fhv.se.smartmeter.application.port.outbound.persistence;

import java.util.Optional;

import at.fhv.se.smartmeter.domain.model.MeterIndividual;


public interface MeterRepository {
    String save(MeterIndividual meter);
    boolean existsById(String id);
    Optional<MeterIndividual> fetchMeterById(String id);
    void assignHouseholdToMeter(String meterId, String householdId);
    void unassignHouseholdFromMeter(String meterId);
    Optional<String> fetchMeterIdForHouseholdId(String householdId);   
}
