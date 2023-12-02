package at.fhv.se.smartmeter.application.service.meterReading;

import java.util.List;

import at.fhv.se.smartmeter.adapter.dto.MeterReadingDTO;
import at.fhv.se.smartmeter.application.port.inbound.meterReading.CreateMeterReadingUseCase;
import at.fhv.se.smartmeter.application.port.inbound.meterReading.GetAllMeterReadingsUseCase;
import at.fhv.se.smartmeter.application.port.outbound.persistence.MeterReadingRepository;
import at.fhv.se.smartmeter.model.MeterReading;

public class MeterReadingService implements CreateMeterReadingUseCase, GetAllMeterReadingsUseCase {

    private final MeterReadingRepository meterReadingRepository;

    public MeterReadingService(MeterReadingRepository meterReadingRepository) {
        this.meterReadingRepository = meterReadingRepository;
    }

    @Override
    public String createMeterReading(MeterReadingDTO meterReadingDTO) {
        //TODO: verify if Meter exists
        MeterReading meterReading = new MeterReading(meterReadingDTO.getTimestamp(), meterReadingDTO.getMeterId(),
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
