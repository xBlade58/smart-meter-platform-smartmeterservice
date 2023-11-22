package at.fhv.se.platform.rest;

import at.fhv.se.platform.application.SmartMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Justin Ströhle
 * 22.11.2023
 */

@RestController
public class DevController {

    @Autowired
    private SmartMeterService smartMeterService;

    @GetMapping ("/devSM")
    public ResponseEntity createSmartMeter(){
        smartMeterService.createSmartMeter("ID1", "MF1");
        return ResponseEntity.ok().build();
    }
}
