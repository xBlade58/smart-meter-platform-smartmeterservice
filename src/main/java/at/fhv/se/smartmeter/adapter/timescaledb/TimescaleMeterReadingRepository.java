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
import at.fhv.se.smartmeter.adapter.timescaledb.mapper.PropertyValueDBValue;
import at.fhv.se.smartmeter.domain.model.MeterReading;
import at.fhv.se.smartmeter.domain.model.PropertyValue;
import at.fhv.se.smartmeter.domain.model.Unit;
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
            return null; //TODO: throw exception
        }
        List<PropertyValueDBValue> propDBValues = mr.getPropertyValues().stream()
            .map(this::mapToPropertyValueDBValue)
            .collect(Collectors.toList());

        MeterReadingDBEntity meterReadingEntity = new MeterReadingDBEntity(mr.getReadingTime(), propDBValues);
        meterReadingEntity.setMeterDBEntity(meterDBEntityOpt.get());
        MeterReadingDBEntity me = meterReadingJpa.save(meterReadingEntity);

        return me.getId().toString();
    }

    @Override
    public List<MeterReading> getAllMeterReadings() {
        List<MeterReadingDBEntity> entites = meterReadingJpa.findAll();
        return entites.stream()
                    .map(this::mapToMeterReading)
                    .collect(Collectors.toList());

    }

    private PropertyValueDBValue mapToPropertyValueDBValue(PropertyValue v) {
        return new PropertyValueDBValue(v.getUnit().getLabel(), v.getDate(), v.getNumericalValue(), v.getOperationalPropertyDefId());
    }

    private PropertyValue mapToPropertyValue(PropertyValueDBValue v) {
        return new PropertyValue(Unit.valueOf(v.getUnit()), v.getDate(), v.getNumericalValue(), v.getOperationalPropertyDefId());
    }

    private MeterReading mapToMeterReading(MeterReadingDBEntity entity) {

        List<PropertyValue> propValues = entity.getJsonProperties().stream()
            .map(this::mapToPropertyValue)
            .collect(Collectors.toList());
        
        return new MeterReading(entity.getId().toString(), entity.getTimestamp(), entity.getMeterDBEntity().getId().toString(), propValues);
    }
    
}
