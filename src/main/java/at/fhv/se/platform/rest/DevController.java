package at.fhv.se.platform.rest;

import at.fhv.se.platform.application.MeterReadingService;
import at.fhv.se.platform.application.SmartMeterService;
import at.fhv.se.platform.dto.MeterReadingDTO;
import at.fhv.se.platform.dto.SmartMeterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Justin Ströhle
 * 22.11.2023
 */

@RestController
@RequestMapping(path = "/dev/v1/")
public class DevController {

    @Autowired
    private SmartMeterService smartMeterService;

    @Autowired
    private MeterReadingService meterReadingService;

    @PostMapping(value = "/CSM", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createSmartMeter(@RequestBody SmartMeterDTO dto) {
        this.smartMeterService.createSmartMeter(dto.getId(), dto.getManufacturer());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/GSM")
    public ResponseEntity getAllSmartMeters() {
        List<SmartMeterDTO> smartMeterDTOs = this.smartMeterService.getAllSmartMeters();
        return ResponseEntity.ok(smartMeterDTOs);
    }

    @PostMapping(value = "/CMR", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createMeterReading(@RequestBody MeterReadingDTO dto) {
        this.meterReadingService.createMeterReading(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/GMR")
    public ResponseEntity getAllMeterReadings() {
        List<MeterReadingDTO> meterReadingDTOs = this.meterReadingService.getAllMeterReadings();
        return ResponseEntity.ok(meterReadingDTOs);
    }
}
