package at.fhv.se.smartmeter.domain.port.outbound.persistence;

public interface OperationalPropertyDefRepository {
    boolean existsById(String id);
}
