package at.fhv.se.smartmeter.application.port.outbound.persistence;

import at.fhv.se.smartmeter.model.Meter;

/**
 * @author Justin Ströhle, Mert Oeztuerk
 * 16.11.2023
 */


// outbound port
public interface MeterRepository {
    long save(Meter meter);   
}
