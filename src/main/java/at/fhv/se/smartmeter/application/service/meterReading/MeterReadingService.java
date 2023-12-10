package at.fhv.se.smartmeter.application.service.meterReading;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import at.fhv.se.smartmeter.adapter.dto.MeterReadingDTO;
import at.fhv.se.smartmeter.application.port.inbound.meterReading.CreateMeterReadingUseCase;
import at.fhv.se.smartmeter.application.port.inbound.meterReading.GetAllMeterReadingsUseCase;
import at.fhv.se.smartmeter.application.port.outbound.persistence.MeterReadingRepository;
import at.fhv.se.smartmeter.model.MeterReading;

// TODO: comments
public class MeterReadingService implements CreateMeterReadingUseCase, GetAllMeterReadingsUseCase {

    private final MeterReadingRepository meterReadingRepository;

    public MeterReadingService(MeterReadingRepository meterReadingRepository) {
        this.meterReadingRepository = meterReadingRepository;
    }

    @Override
    public String createMeterReading(MeterReadingDTO meterReadingDTO) {

        ZonedDateTime zonedDate = LocalDateTime.parse(meterReadingDTO.getTimestamp()).atZone(ZoneId.of("UTC+1"));
        //TODO: verify if Meter exists
        MeterReading meterReading = new MeterReading(zonedDate, UUID.fromString(meterReadingDTO.getMeterId()),
                meterReadingDTO.getPosActInstPower(), meterReadingDTO.getPosActEnergyTotal(),
                meterReadingDTO.getNegActInstPower(), meterReadingDTO.getNegActEnergyTotal(),
                meterReadingDTO.getPosReactEnergyTotal(), meterReadingDTO.getNegReactEnergyTotal(),
                meterReadingDTO.getSumActInstantPower(), meterReadingDTO.getInstCurrL1(),
                meterReadingDTO.getInstVoltL1(), meterReadingDTO.getInstCurrL2(), meterReadingDTO.getInstVoltL2(),
                meterReadingDTO.getInstCurrL3(), meterReadingDTO.getInstVoltL3());
        this.meterReadingRepository.save(meterReading);
        return meterReadingDTO.getTimestamp().toString();        
    }

    @Override
    public List<MeterReading> getAll() {
        return meterReadingRepository.getAllMeterReadings();
    }
    
}
