package at.fhv.se.platform.application;

import at.fhv.se.platform.domain.model.SmartMeter;
import at.fhv.se.platform.dto.SmartMeterDTO;
import at.fhv.se.platform.infrastructure.repository.SmartMeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Justin Ströhle
 * 22.11.2023
 */

@Service
public class SmartMeterServiceImpl implements SmartMeterService{

    @Autowired
    private SmartMeterRepository smartMeterRepository;

    @Override
    public String createSmartMeter(String id, String manufacturer) {
        SmartMeter smartMeter = new SmartMeter(id, manufacturer);
        this.smartMeterRepository.save(smartMeter);
        return id;
    }

    @Override
    public List<SmartMeterDTO> getAllSmartMeters() {
        List<SmartMeter> smartMeters = this.smartMeterRepository.findAll();
        return smartMeters.stream().map(smartMeter -> new SmartMeterDTO(
                smartMeter.getId(),
                smartMeter.getManufacturer()
        )).toList();
    }
}
