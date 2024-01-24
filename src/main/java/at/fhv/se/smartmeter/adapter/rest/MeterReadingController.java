package at.fhv.se.smartmeter.adapter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import at.fhv.se.smartmeter.application.dto.MeterReadingQueryDTO;
import at.fhv.se.smartmeter.application.exceptions.NoMeterForHouseholdException;
import at.fhv.se.smartmeter.application.port.inbound.meterReading.GetMeterReadingForIntervalUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping(path = "/api/v1/meterReadings/")
public class MeterReadingController {
    
    @Autowired
    private GetMeterReadingForIntervalUseCase serviceForInterval;


    @Operation(summary = "Search for meter readings of a household within a given time interval")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Search operation was successful.", 
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MeterReadingQueryDTO.class))}),
        @ApiResponse(responseCode = "404", description = "Household not found")
    })
    @GetMapping(path = "/forInterval/{householdId}")
    public ResponseEntity<List<MeterReadingQueryDTO>> getMeterReadings(
            @PathVariable String householdId,
            @Parameter(description = "Start date for the interval", required = true, schema = @Schema(type = "string", format = "date-time"))
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String startDate,
            @Parameter(description = "End date for the interval", required = true, schema = @Schema(type = "string", format = "date-time"))
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String endDate
    ) {
        try {
            return ResponseEntity.ok(serviceForInterval.getMeterReadingsForInterval(householdId, startDate.toString(), endDate.toString()));
        } catch (NoMeterForHouseholdException e) {
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    
}
