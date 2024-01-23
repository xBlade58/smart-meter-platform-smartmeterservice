package at.fhv.se.smartmeter.application.service.meterReading;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.se.smartmeter.application.dto.CreateMeterReadingDTO;
import at.fhv.se.smartmeter.application.dto.MeterReadingPropDTO;
import at.fhv.se.smartmeter.application.dto.MeterReadingQueryDTO;
import at.fhv.se.smartmeter.application.exceptions.NoMeterForHouseholdException;
import at.fhv.se.smartmeter.application.port.inbound.meterReading.CreateMeterReadingUseCase;
import at.fhv.se.smartmeter.application.port.inbound.meterReading.GetMeterReadingForIntervalUseCase;
import at.fhv.se.smartmeter.application.port.outbound.persistence.MeterReadingRepository;
import at.fhv.se.smartmeter.application.port.outbound.persistence.MeterRepository;
import at.fhv.se.smartmeter.application.port.outbound.persistence.OperationalPropertyDefRepository;
import at.fhv.se.smartmeter.domain.MeterReading;
import at.fhv.se.smartmeter.domain.PropertyValue;
import jakarta.transaction.Transactional;

@Service
public class MeterReadingService implements CreateMeterReadingUseCase, GetMeterReadingForIntervalUseCase {

    @Autowired
    private final MeterReadingRepository meterReadingRepository;

    @Autowired
    private final MeterRepository meterRepository;

    @Autowired
    private final OperationalPropertyDefRepository propertyDefRepo;


    public MeterReadingService(MeterReadingRepository meterReadingRepository, 
        OperationalPropertyDefRepository propertyDefRepo,
        MeterRepository meterRepository) {
        this.meterReadingRepository = meterReadingRepository;
        this.meterRepository = meterRepository;
        this.propertyDefRepo = propertyDefRepo;
    }


    @Transactional
    @Override
    public String createMeterReading(CreateMeterReadingDTO meterReadingDTO) {
        
        //TODO: verify if Meter exists necessary?
        /*
        if (!checkIfAllPropsExist(propDTOs)) {
            return  null;
        } */

        ZonedDateTime readingTime = convertToDateFormat(meterReadingDTO.getReadingTime());
        MeterReadingPropDTO[] propDTOs = meterReadingDTO.getPropertyValues();
        List<PropertyValue> propValues = MeterReadingToDTOMapper.mapToPropertyValues(propDTOs, readingTime);
        MeterReading mr = new MeterReading(meterReadingRepository.nextIdentity(), readingTime, meterReadingDTO.getMeterId(), propValues);

        return meterReadingRepository.save(mr);        

    }


    @Transactional
    @Override
    public List<MeterReadingQueryDTO> getMeterReadingsForInterval(String householdId, String startDate, String endDate) throws NoMeterForHouseholdException {
        
        Optional<String> meterIdOpt = meterRepository.fetchMeterIdForHouseholdId(householdId);
        if (!meterIdOpt.isPresent()) {
            throw new NoMeterForHouseholdException(householdId);
        }
        
        ZonedDateTime start = LocalDateTime.parse(startDate, DateTimeFormatter.ISO_DATE_TIME).atZone(ZoneId.of("UTC"));
        ZonedDateTime end = LocalDateTime.parse(endDate, DateTimeFormatter.ISO_DATE_TIME).atZone(ZoneId.of("UTC"));


        List<MeterReading> readings = meterReadingRepository.getMeterReadingsForInterval(meterIdOpt.get(), start, end);
        
        return MeterReadingToDTOMapper.mapToMeterReadingQueryDTOs(readings);

    }
    
    // Could this theoretically be a domain service?
    private ZonedDateTime convertToDateFormat(String readingTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        return ZonedDateTime.parse(readingTime, dateTimeFormatter);
    }

    // TODO: clarify if this is ok
    private boolean checkIfAllPropsExist(ArrayList<MeterReadingPropDTO> propDTOs) {
        return propDTOs.stream().allMatch(propDto -> propertyDefRepo.existsById(propDto.getOperationalPropertyDef()));
    }


}
