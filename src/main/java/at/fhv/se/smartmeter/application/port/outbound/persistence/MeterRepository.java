package at.fhv.se.smartmeter.application.port.outbound.persistence;

import at.fhv.se.smartmeter.domain.model.Household;
import at.fhv.se.smartmeter.domain.model.MeterIndividual;


public interface MeterRepository {
    String save(MeterIndividual meter);
    boolean existsById(String id);
    void assignHouseholdToMeter(String meterId, Household household);   
}
