package at.fhv.se.smartmeter.application.meterReading;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    
    public MeterReadingService(MeterReadingRepository meterReadingRepository,
            OperationalPropertyDefRepository propertyDefRepo) {
        this.meterReadingRepository = meterReadingRepository;
        this.propertyDefRepo = propertyDefRepo;
    }


    @Override
    public String createMeterReading(MeterReadingDTO dto) {

        ArrayList<MeterReadingPropDTO> propDTOs = new ArrayList<>();
        propDTOs.add(dto.getInstCurrL1());
        propDTOs.add(dto.getInstCurrL2());
        propDTOs.add(dto.getInstCurrL3());
        propDTOs.add(dto.getInstVoltL1());
        propDTOs.add(dto.getInstVoltL2());
        propDTOs.add(dto.getNegActEnergyTotal());
        propDTOs.add(dto.getNegActInstPower());
        propDTOs.add(dto.getNegReactEnergyTotal());
        propDTOs.add(dto.getPosActEnergyTotal());
        propDTOs.add(dto.getPosReactEnergyTotal());
        propDTOs.add(dto.getSumActInstantPower());

        //TODO: verify if Meter exists
        /*
        if (!checkIfAllPropsExist(propDTOs)) {
            return  null;
        } */

        ZonedDateTime zonedDate = LocalDateTime.parse(dto.getTimestamp()).atZone(ZoneId.of("UTC+1"));
        List<PropertyValue> propValues  = new LinkedList<>();
        for (MeterReadingPropDTO propDTO : propDTOs) {
            propValues.add(new PropertyValue(Unit.V, zonedDate, propDTO.getValue(), propDTO.getObisCode()));
        }
        MeterReading mr = new MeterReading(null, zonedDate, dto.getMeterId(), propValues);
        meterReadingRepository.save(mr);

        return dto.getTimestamp().toString();        
    }


    @Override
    public List<MeterReading> getAll() {
        return meterReadingRepository.getAllMeterReadings();
    }

    
    // TODO: clarify if this is ok
    private boolean checkIfAllPropsExist(ArrayList<MeterReadingPropDTO> propDTOs) {
        return propDTOs.stream().allMatch(propDto -> propertyDefRepo.existsById(propDto.getObisCode()));
    }
    
}
