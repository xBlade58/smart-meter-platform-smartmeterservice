package at.fhv.se.smartmeter.adapter.timescaledb.jpaRepos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import at.fhv.se.smartmeter.adapter.timescaledb.model.MeterDBEntity;
import java.util.List;


public interface TimescaleJPAMeter extends JpaRepository<MeterDBEntity, UUID> {
    @Modifying
    @Query("UPDATE MeterDBEntity m SET m.householdId = :newHouseholdId WHERE m.id = :meterId")
    int updateHouseholdId(@Param("meterId") UUID meterId, @Param("newHouseholdId") String newHouseholdId);
    List<MeterDBEntity> findByHouseholdId(String householdId);
}
