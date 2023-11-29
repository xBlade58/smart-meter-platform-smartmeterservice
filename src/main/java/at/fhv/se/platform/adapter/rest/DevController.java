package at.fhv.se.platform.adapter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.fhv.se.platform.adapter.rest.dto.MeterReadingDTO;
import at.fhv.se.platform.application.port.inbound.meter.CreateMeterUseCase;
import at.fhv.se.platform.application.port.inbound.meterReading.CreateMeterReadingUseCase;
import at.fhv.se.platform.application.port.inbound.meterReading.GetAllMeterReadingsUseCase;
import at.fhv.se.platform.model.MeterReading;

/**
 * @author Justin Ströhle
 * 22.11.2023
 */

@RestController
@RequestMapping(path = "/dev/v1/")
public class DevController {

    @Autowired
    private CreateMeterUseCase createMeterService;

    @Autowired
    private GetAllMeterReadingsUseCase getAllMeterReadingsUseCase;

    @Autowired
    private CreateMeterReadingUseCase createMeterReadingUseCase;

    @GetMapping("/createNewMeter")
    public ResponseEntity createNewMeter(){
        int r = this.createMeterService.createMeter(5, "another-tset");
        return ResponseEntity.ok(r);
    }

    @PostMapping(value = "/readings/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createMeterReading(@RequestBody MeterReadingDTO dto) {
        this.createMeterReadingUseCase.createMeterReading(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/readings/getAll")
    public ResponseEntity getAllMeterReadings() {
        List<MeterReading> list = this.getAllMeterReadingsUseCase.getAll();
        List<MeterReadingDTO> dtos = list.stream().map(meterReading -> new MeterReadingDTO(
                meterReading.getTimestamp(),
                meterReading.getMeterId(),
                meterReading.getPosActInstPower(), meterReading.getPosActEnergyTotal(),
                meterReading.getNegActInstPower(), meterReading.getNegActEnergyTotal(),
                meterReading.getPosReactEnergyTotal(), meterReading.getNegReactEnergyTotal(),
                meterReading.getSumActInstantPower(), meterReading.getInstCurr_l1(),
                meterReading.getInstVolt_l1(), meterReading.getInstCurr_l2(), meterReading.getInstVolt_l2(),
                meterReading.getInstCurr_l3(), meterReading.getInstVolt_l3()
        )).toList();
        return ResponseEntity.ok(dtos);
    }
}
