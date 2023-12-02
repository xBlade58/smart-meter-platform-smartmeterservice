package at.fhv.se.platform.application.port.outbound.persistence;

import at.fhv.se.platform.model.Meter;

/**
 * @author Justin Ströhle, Mert Oeztuerk
 * 16.11.2023
 */


// outbound port
public interface MeterRepository {
    void save(Meter meter);   
}
