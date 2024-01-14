package at.fhv.se.smartmeter.adapter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import at.fhv.se.smartmeter.adapter.dto.MeterReadingQueryDTO;
import at.fhv.se.smartmeter.domain.port.inbound.meterReading.GetMeterReadingForIntervalUseCase;


@RestController
@RequestMapping(path = "/api/v1/meterReadings/")
public class MeterReadingController {
    
    @Autowired
    private GetMeterReadingForIntervalUseCase serviceForInterval;

    @GetMapping(path = "/forInterval")
    public List<MeterReadingQueryDTO> getMeterReadings(
            @RequestParam String meterId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String endDate
    ) {
        return serviceForInterval.getMeterReadingsForInterval(meterId, startDate.toString(), endDate.toString());
    }
    
}
