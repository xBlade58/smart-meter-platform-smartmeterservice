package at.fhv.se.smartmeter.application.meterReading;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.se.smartmeter.adapter.dto.MeterReadingDTO;
import at.fhv.se.smartmeter.adapter.dto.MeterReadingPropDTO;
import at.fhv.se.smartmeter.adapter.dto.MeterReadingQueryDTO;
import at.fhv.se.smartmeter.domain.model.MeterReading;
import at.fhv.se.smartmeter.domain.model.PropertyValue;
import at.fhv.se.smartmeter.domain.model.Unit;
import at.fhv.se.smartmeter.domain.port.inbound.meterReading.CreateMeterReadingUseCase;
import at.fhv.se.smartmeter.domain.port.inbound.meterReading.GetAllMeterReadingsUseCase;
import at.fhv.se.smartmeter.domain.port.inbound.meterReading.GetMeterReadingForIntervalUseCase;
import at.fhv.se.smartmeter.domain.port.outbound.persistence.MeterReadingRepository;
import at.fhv.se.smartmeter.domain.port.outbound.persistence.OperationalPropertyDefRepository;

@Service
public class MeterReadingService implements CreateMeterReadingUseCase, GetAllMeterReadingsUseCase, GetMeterReadingForIntervalUseCase {

    @Autowired
    private final MeterReadingRepository meterReadingRepository;

    @Autowired
    private final OperationalPropertyDefRepository propertyDefRepo;


    public MeterReadingService(MeterReadingRepository meterReadingRepository, OperationalPropertyDefRepository propertyDefRepo) {
        this.meterReadingRepository = meterReadingRepository;
        this.propertyDefRepo = propertyDefRepo;
    }


    @Override
    public String createMeterReading(MeterReadingDTO meterReadingDTO) {
        
        //TODO: verify if Meter exists necessary?
        /*
        if (!checkIfAllPropsExist(propDTOs)) {
            return  null;
        } */

        ZonedDateTime readingTime = convertToDateFormat(meterReadingDTO.getReadingTime());

        MeterReadingPropDTO[] propDTOs = meterReadingDTO.getPropertyValues();
        List<PropertyValue> propValues = Arrays.stream(propDTOs)
            .map(propDTO -> new PropertyValue(
                Unit.fromString(propDTO.getUnit()),
                readingTime,
                propDTO.getValue(),
                propDTO.getOperationalPropertyDef()
            ))
            .collect(Collectors.toList());
        MeterReading mr = new MeterReading(meterReadingRepository.nextIdentity(), readingTime, meterReadingDTO.getMeterId(), propValues);
        meterReadingRepository.save(mr);

        return meterReadingDTO.getReadingTime().toString();        
    }


    @Override
    public List<MeterReading> getAll() {
        return meterReadingRepository.getAllMeterReadings();
    }

    
    // TODO: clarify if this is ok
    private boolean checkIfAllPropsExist(ArrayList<MeterReadingPropDTO> propDTOs) {
        return propDTOs.stream().allMatch(propDto -> propertyDefRepo.existsById(propDto.getOperationalPropertyDef()));
    }


    @Override
    public List<MeterReadingQueryDTO> getMeterReadingsForInterval(String meterId, String startDate, String endDate) {
        ZonedDateTime start = LocalDateTime.parse(startDate, DateTimeFormatter.ISO_DATE_TIME).atZone(ZoneId.of("UTC"));
        ZonedDateTime end = LocalDateTime.parse(endDate, DateTimeFormatter.ISO_DATE_TIME).atZone(ZoneId.of("UTC"));
        List<MeterReading> readings = meterReadingRepository.getMeterReadingsForInterval(meterId, start, end);
        return mapToMeterReadingQueryDTOs(readings);

    }
    
    // Could this theoretically be a domain service?
    private ZonedDateTime convertToDateFormat(String readingTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        return ZonedDateTime.parse(readingTime, dateTimeFormatter);
    }

    private List<MeterReadingQueryDTO> mapToMeterReadingQueryDTOs(List<MeterReading> readings) {
        return readings.stream().map(reading ->
            MeterReadingQueryDTO.builder()
                .id(reading.getId())
                .readingTime(reading.getReadingTime().toString())
                .meterId(reading.getMeterIndividualId())
                .propertyValues(mapToPropDTOs(reading.getPropertyValues()))
                .build()     
        ).collect(Collectors.toList());
    }

    private MeterReadingPropDTO[] mapToPropDTOs(List<PropertyValue> propertyValues) {
        return propertyValues.stream().map(prop -> 
             MeterReadingPropDTO.builder()
                .operationalPropertyDef(prop.getOperationalPropertyDefId())
                .value(prop.getNumericalValue())
                .unit(prop.getUnit().getLabel())
                .build()
        ).collect(Collectors.toList()).toArray(new MeterReadingPropDTO[0]);
    } 


}
