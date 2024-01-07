package at.fhv.se.smartmeter.adapter.timescaledb;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import at.fhv.se.smartmeter.adapter.timescaledb.jpaRepos.TimescaleJPAMeter;
import at.fhv.se.smartmeter.adapter.timescaledb.jpaRepos.TimescaleJPAMeterReading;
import at.fhv.se.smartmeter.adapter.timescaledb.mapper.MeterDBEntity;
import at.fhv.se.smartmeter.adapter.timescaledb.mapper.MeterReadingDBEntity;
import at.fhv.se.smartmeter.adapter.timescaledb.mapper.PropertyValueDBEmbeddable;
import at.fhv.se.smartmeter.domain.model.MeterReading;
import at.fhv.se.smartmeter.domain.model.PropertyValue;
import at.fhv.se.smartmeter.domain.port.outbound.persistence.MeterReadingRepository;

@Repository
public class TimescaleMeterReadingRepository implements MeterReadingRepository {

    @Autowired
    private TimescaleJPAMeterReading meterReadingJpa;

    @Autowired
    private TimescaleJPAMeter meterJpa;
    
    @Override
    public String save(MeterReading mr) {
        Optional<MeterDBEntity> meterDBEntityOpt = meterJpa.findById(UUID.fromString(mr.getMeterIndividualId()));
        if (!meterDBEntityOpt.isPresent()) {
            return null; // throw exception
        }
        MeterReadingDBEntity meterReadingEntity = new MeterReadingDBEntity(mr.getReadingTime(),
            mapToDbEmbeddable(mr.getPosActInstPower()),
            mapToDbEmbeddable(mr.getPosReactEnergyTotal()),
            mapToDbEmbeddable(mr.getNegActInstPower()),
            mapToDbEmbeddable(mr.getNegActEnergyTotal()), 
            mapToDbEmbeddable(mr.getPosReactEnergyTotal()),
            mapToDbEmbeddable(mr.getNegReactEnergyTotal()),
            mapToDbEmbeddable(mr.getSumActInstantPower()),
            mapToDbEmbeddable(mr.getInstCurr_l1()),
            mapToDbEmbeddable(mr.getInstVolt_l1()),
            mapToDbEmbeddable(mr.getInstCurr_l2()),
            mapToDbEmbeddable(mr.getInstVolt_l2()),
            mapToDbEmbeddable(mr.getInstCurr_l3()),
            mapToDbEmbeddable(mr.getInstVolt_l3()));

        meterReadingEntity.setMeterDBEntity(meterDBEntityOpt.get());
        MeterReadingDBEntity me = meterReadingJpa.save(meterReadingEntity);
        return me.getId().toString();
    }

    @Override
    public List<MeterReading> getAllMeterReadings() {
        List<MeterReadingDBEntity> entites = meterReadingJpa.findAll();
        return entites.stream()
                    .map(TimescaleMeterReadingRepository::mapToMeterReading)
                    .collect(Collectors.toList());

    }

    private static PropertyValueDBEmbeddable mapToDbEmbeddable(PropertyValue v) {
        return new PropertyValueDBEmbeddable(v.getUnit(), v.getDate(), v.getNumericalValue(), v.getOperationalPropertyDefId());
    }

    private static PropertyValue mapToPropertyValue(PropertyValueDBEmbeddable v) {
        return new PropertyValue(v.getUnit(), v.getDate(), v.getNumericalValue(), v.getOperationalPropertyDefId());
    }

    private static MeterReading mapToMeterReading(MeterReadingDBEntity entity) {

        return new MeterReading(
            entity.getId().toString(),
            entity.getTimestamp(),
            entity.getMeterId().toString(),
            mapToPropertyValue(entity.getPosActInstPower()),
            mapToPropertyValue(entity.getPosReactEnergyTotal()),
            mapToPropertyValue(entity.getNegActInstPower()),
            mapToPropertyValue(entity.getNegActEnergyTotal()), 
            mapToPropertyValue(entity.getPosReactEnergyTotal()),
            mapToPropertyValue(entity.getNegReactEnergyTotal()),
            mapToPropertyValue(entity.getSumActInstantPower()),
            mapToPropertyValue(entity.getInstCurr_l1()),
            mapToPropertyValue(entity.getInstVolt_l1()),
            mapToPropertyValue(entity.getInstCurr_l2()),
            mapToPropertyValue(entity.getInstVolt_l2()),
            mapToPropertyValue(entity.getInstCurr_l3()),
            mapToPropertyValue(entity.getInstVolt_l3())
        );
    }
    
}
