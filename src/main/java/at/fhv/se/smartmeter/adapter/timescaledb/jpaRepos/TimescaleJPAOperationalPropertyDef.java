package at.fhv.se.smartmeter.adapter.timescaledb.jpaRepos;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fhv.se.smartmeter.adapter.timescaledb.model.OperationalPropertyDefDBEntity;

public interface TimescaleJPAOperationalPropertyDef extends JpaRepository<OperationalPropertyDefDBEntity, String> {
    
}
