package at.fhv.se.smartmeter.adapter.timescaledb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import at.fhv.se.smartmeter.adapter.timescaledb.mapper.MeterDBEntity;
import at.fhv.se.smartmeter.domain.model.MeterIndividual;
import at.fhv.se.smartmeter.domain.port.outbound.persistence.MeterRepository;

@Repository
public class TimescaleMeterRepository implements MeterRepository {

    @Autowired
    private TimescaleJPAMeter meterJPARepo;
    

    @Override
    public String save(MeterIndividual meter) {
        MeterDBEntity mm = new MeterDBEntity(meter.getSerialNumber(), meter.getSerialNumber());
        MeterDBEntity savedMeter = this.meterJPARepo.save(mm);
        System.out.println(savedMeter.getId());
        return savedMeter.getId().toString();
    }

}
