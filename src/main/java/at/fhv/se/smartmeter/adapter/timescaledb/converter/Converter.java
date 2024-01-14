package at.fhv.se.smartmeter.adapter.timescaledb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import at.fhv.se.smartmeter.adapter.timescaledb.mapper.MeterReadingDBEntity;
import at.fhv.se.smartmeter.adapter.timescaledb.mapper.PropertyValueDBValue;
import at.fhv.se.smartmeter.domain.model.MeterReading;
import at.fhv.se.smartmeter.domain.model.PropertyValue;
import at.fhv.se.smartmeter.domain.model.Unit;

@Component
public class Converter {

    public PropertyValueDBValue mapToPropertyValueDBValue(PropertyValue v) {
        return new PropertyValueDBValue(v.getUnit().getLabel(), v.getDate(), v.getNumericalValue(), v.getOperationalPropertyDefId());
    }

    public PropertyValue mapToPropertyValue(PropertyValueDBValue v) {
        return new PropertyValue(Unit.fromString(v.getUnit()), v.getDate(), v.getNumericalValue(), v.getOperationalPropertyDefId());
    }

    public MeterReading mapToMeterReading(MeterReadingDBEntity entity) {

        List<PropertyValue> propValues = entity.getJsonProperties().stream()
            .map(this::mapToPropertyValue)
            .collect(Collectors.toList());
        
        return new MeterReading(entity.getId().toString(), entity.getReadingTime(), entity.getMeterDBEntity().getId().toString(), propValues);
    }
}
