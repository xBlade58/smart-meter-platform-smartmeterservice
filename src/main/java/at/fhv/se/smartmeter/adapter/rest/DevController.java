package at.fhv.se.smartmeter.adapter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.fhv.se.smartmeter.adapter.dto.MeterReadingDTO;
import at.fhv.se.smartmeter.application.port.inbound.meter.CreateMeterUseCase;
import at.fhv.se.smartmeter.application.port.inbound.meterReading.CreateMeterReadingUseCase;
import at.fhv.se.smartmeter.application.port.inbound.meterReading.GetAllMeterReadingsUseCase;
import at.fhv.se.smartmeter.model.MeterReading;

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
        String r = this.createMeterService.createMeter(10, "lets see");
        String r2 = this.createMeterService.createMeter(5, "VKW");
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
        List<MeterReadingDTO> dtos = list.stream().map(meterReading -> 
        
        MeterReadingDTO.builder()
            .timestamp(meterReading.getTimestamp().toString())
            .meterId(meterReading.getMeterId().toString())
            .posActInstPower(meterReading.getPosActInstPower())
            .posActEnergyTotal(meterReading.getPosActEnergyTotal())
            .negActInstPower(meterReading.getNegActInstPower())
            .negActEnergyTotal(meterReading.getNegActEnergyTotal())
            .sumActInstantPower(meterReading.getSumActInstantPower())
            .instCurrL1(meterReading.getInstCurr_l1())
            .instVoltL1(meterReading.getInstVolt_l1())
            .instCurrL2(meterReading.getInstCurr_l2())
            .instVoltL2(meterReading.getInstVolt_l2())
            .instCurrL3(meterReading.getInstVolt_l3())
            .instVoltL3(meterReading.getInstVolt_l3())
            .build()).toList();
            
        return ResponseEntity.ok(dtos);
    }
}
