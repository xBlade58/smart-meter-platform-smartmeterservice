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
    public int save(Meter meter) {
        Meter savedMeter = this.meterJPARepo.save(meter);
        System.out.println(savedMeter.getId());
        return savedMeter.getId();
    }

}
