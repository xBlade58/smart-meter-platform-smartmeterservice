package at.fhv.se.smartmeter.application.port.outbound.persistence;

public interface OperationalPropertyDefRepository {
    boolean existsById(String id);
}
