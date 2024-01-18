package at.fhv.se.smartmeter.application.meterReading;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import at.fhv.se.smartmeter.application.dto.MeterReadingPropDTO;
import at.fhv.se.smartmeter.application.dto.MeterReadingQueryDTO;
import at.fhv.se.smartmeter.domain.model.MeterReading;
import at.fhv.se.smartmeter.domain.model.PropertyValue;
import at.fhv.se.smartmeter.domain.model.Unit;

public class MeterReadingToDTOMapper {


    public static List<MeterReadingQueryDTO> mapToMeterReadingQueryDTOs(List<MeterReading> readings) {
        return readings.stream().map(reading ->
            MeterReadingQueryDTO.builder()
                .id(reading.getId())
                .readingTime(reading.getReadingTime().toString())
                .meterId(reading.getMeterIndividualId())
                .propertyValues(mapToPropDTOs(reading.getPropertyValues()))
                .build()     
        ).collect(Collectors.toList());
    }

    public static MeterReadingPropDTO[] mapToPropDTOs(List<PropertyValue> propertyValues) {
        return propertyValues.stream().map(prop -> 
             MeterReadingPropDTO.builder()
                .operationalPropertyDef(prop.getOperationalPropertyDefId())
                .value(prop.getNumericalValue())
                .unit(prop.getUnit().getLabel())
                .build()
        ).collect(Collectors.toList()).toArray(new MeterReadingPropDTO[0]);
    }

    public static List<PropertyValue> mapToPropertyValues(MeterReadingPropDTO[] dtos, ZonedDateTime readingTime) {
        return Arrays.stream(dtos)
            .map(propDTO -> new PropertyValue(
                Unit.fromString(propDTO.getUnit()),
                readingTime,
                propDTO.getValue(),
                propDTO.getOperationalPropertyDef()
            ))
            .collect(Collectors.toList());
        
    }
}
