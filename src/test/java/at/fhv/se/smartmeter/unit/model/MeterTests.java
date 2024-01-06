package at.fhv.se.smartmeter.unit.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.fhv.se.smartmeter.domain.model.MeterIndividual;

public class MeterTests {
    
    @Test
    void test_meterCreation() {
        // given
        int serialNumber = 1234;
        String manufacturer = "VKW";

        // when
        MeterIndividual m = new MeterIndividual(serialNumber, manufacturer);

        // then
        assertEquals(m.getId(), 0);
        assertEquals(m.getSerialNumber(), manufacturer);
        assertEquals(m.getSerialNumber(), m.getSerialNumber());
    }
}
