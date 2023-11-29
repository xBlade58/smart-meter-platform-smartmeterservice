package at.fhv.se.platform.adapter.timescaledb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import at.fhv.se.platform.application.port.outbound.persistence.MeterRepository;
import at.fhv.se.platform.model.Meter;

@Repository
public class TimescaleMeterRepository implements MeterRepository {

    @Autowired
    private TimescaleJPAMeter meterJPARepo;
    

    @Override
    public void save(Meter meter) {
        this.meterJPARepo.save(meter);
    }

}
