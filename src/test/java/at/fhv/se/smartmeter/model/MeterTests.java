package at.fhv.se.smartmeter.model;

import org.junit.jupiter.api.Test;

public class MeterTests {
    
    @Test
    void meter_detailsEquals() {
        // given
        int serialNumber = 1234;
        String manufacturer = "VKW";

        // when
        Meter m = new Meter(serialNumber, manufacturer);
    }
}
