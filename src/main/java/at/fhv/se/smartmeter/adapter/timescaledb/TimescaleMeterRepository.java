package at.fhv.se.smartmeter.adapter.timescaledb;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import at.fhv.se.smartmeter.adapter.timescaledb.jpaRepos.TimescaleJPAMeter;
import at.fhv.se.smartmeter.adapter.timescaledb.jpaRepos.TimescaleJPAPhysicalMeter;
import at.fhv.se.smartmeter.adapter.timescaledb.mapper.MeterIndividualToDBEntityMapper;
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

    @Autowired
    private MeterIndividualToDBEntityMapper mapper;


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


    @Override
    public void assignHouseholdToMeter(String meterId, String householdId) {
        int res = meterJpa.updateHouseholdId(UUID.fromString(meterId), householdId);
        if (res == 0) {
            //TOOD: throw exception
        }
    }

    @Override
    public void unassignHouseholdFromMeter(String meterId) {
       int res = meterJpa.updateHouseholdId(UUID.fromString(meterId), null);
       System.out.println(res);
    }


    @Override
    public Optional<MeterIndividual> fetchMeterById(String id) {
        Optional<MeterDBEntity> entityOpt = meterJpa.findById(UUID.fromString(id));
        if (!entityOpt.isPresent()) {
            return Optional.empty();
        }
        MeterIndividual meter = mapper.mapToMeter(entityOpt.get());
        return Optional.of(meter);
    }


    @Override
    public Optional<String> fetchMeterIdForHouseholdId(String householdId) {
        List<MeterDBEntity> meters = meterJpa.findByHouseholdId(householdId);
        if (meters.size() > 0) {
            return Optional.of(meters.get(0).getId().toString()); //TODO: add note
        } else {
            return Optional.empty();
        }
    }


}
