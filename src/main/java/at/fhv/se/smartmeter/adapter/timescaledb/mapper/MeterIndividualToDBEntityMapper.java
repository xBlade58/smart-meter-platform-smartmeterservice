package at.fhv.se.smartmeter.adapter.timescaledb.mapper;

import org.springframework.stereotype.Component;

import at.fhv.se.smartmeter.adapter.timescaledb.model.MeterDBEntity;
import at.fhv.se.smartmeter.domain.model.MeterIndividual;

@Component
public class MeterIndividualToDBEntityMapper {
    
    public MeterIndividual mapToMeter(MeterDBEntity entity) {
        return new MeterIndividual(entity.getId().toString(), entity.getSerialNumber(),
            entity.getPhysicalMeter().getId().toString(), entity.getHouseholdId());
    }

    public MeterDBEntity mapToMeterDBEntity(MeterIndividual meter) {
        return new MeterDBEntity(meter.getSerialNumber());
    }
}
