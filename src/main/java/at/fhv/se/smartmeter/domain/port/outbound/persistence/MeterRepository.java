package at.fhv.se.smartmeter.domain.port.outbound.persistence;

import at.fhv.se.smartmeter.domain.model.MeterIndividual;


public interface MeterRepository {
    String save(MeterIndividual meter);
    boolean existsById(String id);   
}
