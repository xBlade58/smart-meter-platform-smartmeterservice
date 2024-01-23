package at.fhv.se.smartmeter.adapter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import at.fhv.se.smartmeter.application.dto.MeterReadingQueryDTO;
import at.fhv.se.smartmeter.application.exceptions.NoMeterForHouseholdException;
import at.fhv.se.smartmeter.application.port.inbound.meterReading.GetMeterReadingForIntervalUseCase;


@RestController
@RequestMapping(path = "/api/v1/meterReadings/")
public class MeterReadingController {
    
    @Autowired
    private GetMeterReadingForIntervalUseCase serviceForInterval;

    //TODO: How to pass Timezone info?
    @GetMapping(path = "/forInterval")
    public ResponseEntity<List<MeterReadingQueryDTO>> getMeterReadings(
            @RequestParam String householdId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String endDate
    ) {
        try {
            return ResponseEntity.ok(serviceForInterval.getMeterReadingsForInterval(householdId, startDate.toString(), endDate.toString()));
        } catch (NoMeterForHouseholdException e) {
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    
}
