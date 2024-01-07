package at.fhv.se.smartmeter.application.meterReading;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.se.smartmeter.adapter.dto.MeterReadingDTO;
import at.fhv.se.smartmeter.adapter.dto.MeterReadingPropDTO;
import at.fhv.se.smartmeter.domain.model.MeterReading;
import at.fhv.se.smartmeter.domain.model.PropertyValue;
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

        //TODO: verify if Meter exists
        if (!checkIfAllPropsExist(dto)) {
            return  null; //TODO: throw exception
        }

        ZonedDateTime zonedDate = LocalDateTime.parse(dto.getTimestamp()).atZone(ZoneId.of("UTC+1"));
        
        MeterReading mr = new MeterReading(null, zonedDate, dto.getMeterId(),
            new PropertyValue(null, zonedDate, dto.getPosActInstPower().getValue(), dto.getPosActInstPower().getObisCode()),
            new PropertyValue(null, zonedDate, dto.getPosActEnergyTotal().getValue(), dto.getPosActEnergyTotal().getObisCode()),
            new PropertyValue(null, zonedDate, dto.getNegActInstPower().getValue(), dto.getNegActInstPower().getObisCode()),
            new PropertyValue(null, zonedDate, dto.getNegActEnergyTotal().getValue(), dto.getNegActEnergyTotal().getObisCode()),
            new PropertyValue(null, zonedDate, dto.getPosReactEnergyTotal().getValue(), dto.getPosReactEnergyTotal().getObisCode()),
            new PropertyValue(null, zonedDate, dto.getNegReactEnergyTotal().getValue(), dto.getNegReactEnergyTotal().getObisCode()),
            new PropertyValue(null, zonedDate, dto.getSumActInstantPower().getValue(), dto.getSumActInstantPower().getObisCode()),

            new PropertyValue(null, zonedDate, dto.getInstCurrL1().getValue(), dto.getInstCurrL1().getObisCode()),
            new PropertyValue(null, zonedDate, dto.getInstVoltL1().getValue(), dto.getInstVoltL1().getObisCode()),
            new PropertyValue(null, zonedDate, dto.getInstCurrL2().getValue(), dto.getInstCurrL2().getObisCode()),
            new PropertyValue(null, zonedDate, dto.getInstVoltL2().getValue(), dto.getInstVoltL2().getObisCode()),
            new PropertyValue(null, zonedDate, dto.getInstCurrL3().getValue(), dto.getInstCurrL3().getObisCode()),
            new PropertyValue(null, zonedDate, dto.getInstVoltL3().getValue(), dto.getInstVoltL3().getObisCode()));

        meterReadingRepository.save(mr);

        return dto.getTimestamp().toString();        
    }


    @Override
    public List<MeterReading> getAll() {
        return meterReadingRepository.getAllMeterReadings();
    }

    
    // TODO: clarify if this is ok
    private boolean checkIfAllPropsExist(MeterReadingDTO dto) {
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

        return propDTOs.stream().allMatch(propDto -> propertyDefRepo.existsById(propDto.getObisCode()));
    }
    
}
