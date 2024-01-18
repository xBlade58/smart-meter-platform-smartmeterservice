package at.fhv.se.smartmeter.adapter.timescaledb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import at.fhv.se.smartmeter.adapter.timescaledb.jpaRepos.TimescaleJPAOperationalPropertyDef;
import at.fhv.se.smartmeter.application.port.outbound.persistence.OperationalPropertyDefRepository;

@Repository
public class TimescaleOperationalPropertyDefRepository implements OperationalPropertyDefRepository {

    @Autowired
    private TimescaleJPAOperationalPropertyDef jpa;

    @Override
    public boolean existsById(String id) {
        return jpa.existsById(id);
    }
    
}
