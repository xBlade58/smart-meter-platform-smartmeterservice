package at.fhv.se.smartmeter.adapter.timescaledb.jpaRepos;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fhv.se.smartmeter.adapter.timescaledb.mapper.OperationalPropertyDefDBEntity;

public interface TimescaleJPAOperationalPropertyDef extends JpaRepository<OperationalPropertyDefDBEntity, String> {
    
}
