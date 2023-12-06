package at.fhv.se.smartmeter.adapter.timescaledb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import at.fhv.se.smartmeter.adapter.timescaledb.mapper.MeterDBEntity;
import at.fhv.se.smartmeter.application.port.outbound.persistence.MeterRepository;
import at.fhv.se.smartmeter.model.Meter;

@Repository
public class TimescaleMeterRepository implements MeterRepository {

    @Autowired
    private TimescaleJPAMeter meterJPARepo;
    

    @Override
    public long save(Meter meter) {
        MeterDBEntity mm = new MeterDBEntity(meter.getSerialNumber(), meter.getManufacturer());
        MeterDBEntity savedMeter = this.meterJPARepo.save(mm);
        System.out.println(savedMeter.getId());
        return savedMeter.getId();
    }

}
