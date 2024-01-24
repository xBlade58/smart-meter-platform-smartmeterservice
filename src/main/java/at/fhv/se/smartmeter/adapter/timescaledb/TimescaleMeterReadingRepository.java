package at.fhv.se.smartmeter.adapter.timescaledb;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import at.fhv.se.smartmeter.adapter.timescaledb.jpaRepos.TimescaleJPAMeter;
import at.fhv.se.smartmeter.adapter.timescaledb.jpaRepos.TimescaleJPAMeterReading;
import at.fhv.se.smartmeter.adapter.timescaledb.mapper.MeterReadingToDBEntityMapper;
import at.fhv.se.smartmeter.adapter.timescaledb.model.MeterDBEntity;
import at.fhv.se.smartmeter.adapter.timescaledb.model.MeterReadingDBEntity;
import at.fhv.se.smartmeter.adapter.timescaledb.model.PropertyValueDBValue;
import at.fhv.se.smartmeter.application.port.outbound.persistence.MeterReadingRepository;
import at.fhv.se.smartmeter.domain.MeterReading;

@Repository
public class TimescaleMeterReadingRepository implements MeterReadingRepository {
    
    @Autowired
    private TimescaleJPAMeterReading meterReadingJpa;

    @Autowired
    private TimescaleJPAMeter meterJpa;
    
    @Autowired
    private MeterReadingToDBEntityMapper converter;

    @Override
    public String nextIdentity() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String save(MeterReading mr) {
        
        Optional<MeterDBEntity> meterDBEntityOpt = meterJpa.findById(UUID.fromString(mr.getMeterIndividualId()));
        if (!meterDBEntityOpt.isPresent()) {
            return null; //TODO: throw exception
        }
        List<PropertyValueDBValue> propDBValues = mr.getPropertyValues().stream()
            .map(converter::mapToPropertyValueDBValue)
            .collect(Collectors.toList());

        MeterReadingDBEntity meterReadingEntity = new MeterReadingDBEntity(UUID.fromString(mr.getId()), mr.getReadingTime(), propDBValues);
        meterReadingEntity.setMeterDBEntity(meterDBEntityOpt.get());
        meterReadingEntity = meterReadingJpa.save(meterReadingEntity);
        return meterReadingEntity.getId().toString();
    }

    @Override
    public List<MeterReading> getAllMeterReadings() {
        List<MeterReadingDBEntity> entities = meterReadingJpa.findAll();
        return entities.stream()
                    .map(converter::mapToMeterReading)
                    .collect(Collectors.toList());

    }

    @Override
    public List<MeterReading> getMeterReadingsForInterval(String meterId, ZonedDateTime start, ZonedDateTime end) {
        List<MeterReadingDBEntity> entities = meterReadingJpa.findByReadingTimeBetween(UUID.fromString(meterId), start, end);
        return entities.stream()
                    .map(converter::mapToMeterReading)
                    .collect(Collectors.toList());
    }

    
}
