package at.fhv.se.platform.infrastructure.repository;

import at.fhv.se.platform.domain.model.SmartMeter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Justin Ströhle
 * 16.11.2023
 */

@Repository
public interface SmartMeterRepository extends JpaRepository<SmartMeter, Integer> {
}
