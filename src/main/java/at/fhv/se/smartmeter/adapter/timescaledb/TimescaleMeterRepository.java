package at.fhv.se.smartmeter.adapter.timescaledb;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import at.fhv.se.smartmeter.adapter.timescaledb.jpaRepos.TimescaleJPAMeter;
import at.fhv.se.smartmeter.adapter.timescaledb.jpaRepos.TimescaleJPAPhysicalMeter;
import at.fhv.se.smartmeter.adapter.timescaledb.model.MeterDBEntity;
import at.fhv.se.smartmeter.adapter.timescaledb.model.PhysicalMeterDBEntity;
import at.fhv.se.smartmeter.application.port.outbound.persistence.MeterRepository;
import at.fhv.se.smartmeter.domain.model.MeterIndividual;

@Repository
public class TimescaleMeterRepository implements MeterRepository {

    @Autowired
    private TimescaleJPAMeter meterJpa;

    @Autowired 
    private TimescaleJPAPhysicalMeter physicalMeterJpa;
    

    @Override
    public String save(MeterIndividual meter) {
        Optional<PhysicalMeterDBEntity> physicalMeterOpt = physicalMeterJpa.findById(UUID.fromString(meter.getPhysicalMeterId()));
        if (!physicalMeterOpt.isPresent()) {
            return null; // throw exception
        }

        MeterDBEntity mm = new MeterDBEntity(meter.getSerialNumber());
        mm.setPhysicalMeter(physicalMeterOpt.get());
        MeterDBEntity savedMeter = this.meterJpa.save(mm);
        System.out.println("Meter saved with ID: " + savedMeter.getId().toString());
        return savedMeter.getId().toString();
    }


    @Override
    public boolean existsById(String id) {
        return meterJpa.existsById(UUID.fromString(id));
    }

}
