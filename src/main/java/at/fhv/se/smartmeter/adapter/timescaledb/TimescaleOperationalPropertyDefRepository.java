package at.fhv.se.smartmeter.adapter.timescaledb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.se.smartmeter.adapter.timescaledb.jpaRepos.TimescaleJPAOperationalPropertyDef;
import at.fhv.se.smartmeter.application.port.outbound.persistence.OperationalPropertyDefRepository;

@Service
public class TimescaleOperationalPropertyDefRepository implements OperationalPropertyDefRepository {

    @Autowired
    private TimescaleJPAOperationalPropertyDef jpa;

    @Override
    public boolean existsById(String id) {
        return jpa.existsById(id);
    }
    
}
