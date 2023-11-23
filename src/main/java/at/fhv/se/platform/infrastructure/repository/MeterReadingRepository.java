package at.fhv.se.platform.infrastructure.repository;

import at.fhv.se.platform.domain.model.MeterReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Justin Ströhle
 * 23.11.2023
 */

@Repository
public interface MeterReadingRepository  extends JpaRepository<MeterReading, String> {
}
