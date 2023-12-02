package at.fhv.se.smartmeter.adapter.timescaledb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import at.fhv.se.smartmeter.application.port.outbound.persistence.MeterRepository;
import at.fhv.se.smartmeter.model.Meter;

@Repository
public class TimescaleMeterRepository implements MeterRepository {

    @Autowired
    private TimescaleJPAMeter meterJPARepo;
    

    @Override
    public void save(Meter meter) {
        this.meterJPARepo.save(meter);
    }

}
