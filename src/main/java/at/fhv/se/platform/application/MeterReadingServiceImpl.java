package at.fhv.se.platform.application;

import at.fhv.se.platform.domain.model.MeterReading;
import at.fhv.se.platform.dto.MeterReadingDTO;
import at.fhv.se.platform.infrastructure.repository.MeterReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Justin Ströhle
 * 23.11.2023
 */

@Service
public class MeterReadingServiceImpl implements MeterReadingService {

    @Autowired
    private MeterReadingRepository meterReadingRepository;

    @Override
    public String createMeterReading(MeterReadingDTO meterReadingDTO) {
        MeterReading meterReading = new MeterReading(meterReadingDTO.getTimestamp(),
                meterReadingDTO.getPosActInstPower(), meterReadingDTO.getPosActEnergyTotal(),
                meterReadingDTO.getNegActInstPower(), meterReadingDTO.getNegActEnergyTotal(),
                meterReadingDTO.getPosReactEnergyTotal(), meterReadingDTO.getNegReactEnergyTotal(),
                meterReadingDTO.getSumActInstantPower(), meterReadingDTO.getInstCurrL1(),
                meterReadingDTO.getInstVoltL1(), meterReadingDTO.getInstCurrL2(), meterReadingDTO.getInstVoltL2(),
                meterReadingDTO.getInstCurrL3(), meterReadingDTO.getInstVoltL3());
        this.meterReadingRepository.save(meterReading);
        return "TODO";
    }

    @Override
    public List<MeterReadingDTO> getAllMeterReadings() {
        List<MeterReading> meterReadings = this.meterReadingRepository.findAll();
        return meterReadings.stream().map(meterReading -> new MeterReadingDTO(
                meterReading.getTimestamp(),
                meterReading.getPosActInstPower(), meterReading.getPosActEnergyTotal(),
                meterReading.getNegActInstPower(), meterReading.getNegActEnergyTotal(),
                meterReading.getPosReactEnergyTotal(), meterReading.getNegReactEnergyTotal(),
                meterReading.getSumActInstantPower(), meterReading.getInstCurrL1(),
                meterReading.getInstVoltL1(), meterReading.getInstCurrL2(), meterReading.getInstVoltL2(),
                meterReading.getInstCurrL3(), meterReading.getInstVoltL3()
        )).toList();
    }
}
