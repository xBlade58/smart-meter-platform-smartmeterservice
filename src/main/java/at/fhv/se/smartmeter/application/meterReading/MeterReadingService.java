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
import at.fhv.se.smartmeter.domain.model.MeterReading;
import at.fhv.se.smartmeter.domain.model.PropertyValue;
import at.fhv.se.smartmeter.domain.model.Unit;
import at.fhv.se.smartmeter.domain.port.inbound.meterReading.CreateMeterReadingUseCase;
import at.fhv.se.smartmeter.domain.port.inbound.meterReading.GetAllMeterReadingsUseCase;
import at.fhv.se.smartmeter.domain.port.outbound.persistence.MeterReadingRepository;
import at.fhv.se.smartmeter.domain.port.outbound.persistence.OperationalPropertyDefRepository;

@Service
public class MeterReadingService implements CreateMeterReadingUseCase, GetAllMeterReadingsUseCase {

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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        ZonedDateTime readingTime = ZonedDateTime.parse(meterReadingDTO.getReadingTime(), formatter);

        MeterReadingPropDTO[] propDTOs = meterReadingDTO.getPropertyValues();
        List<PropertyValue> propValues = Arrays.stream(propDTOs)
            .map(propDTO -> new PropertyValue(
                Unit.valueOf(propDTO.getUnit()),
                readingTime,
                propDTO.getValue(),
                propDTO.getOperationalPropertyDef()
            ))
            .collect(Collectors.toList());
        MeterReading mr = new MeterReading(null, readingTime, meterReadingDTO.getMeterId(), propValues);
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
    
}
