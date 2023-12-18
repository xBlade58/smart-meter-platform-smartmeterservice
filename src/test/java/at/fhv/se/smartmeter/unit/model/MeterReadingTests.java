package at.fhv.se.smartmeter.unit.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import at.fhv.se.smartmeter.model.MeterReading;

public class MeterReadingTests {
    
    @Test
    public void test_meterReadingCreation() {
        // given
        ZonedDateTime timestamp = ZonedDateTime.now(ZoneId.of("UTC+1"));

        // when
        MeterReading meterReading = new MeterReading(timestamp, UUID.randomUUID(), 100, 1000, 50, 500, 200, 200, 150,
                10.5f, 220.0f, 20.0f, 230.0f, 30.0f, 40.0f);

        // then
        assertEquals(timestamp, meterReading.getTimestamp());
        assertEquals(1, meterReading.getMeterId());
        assertEquals(100, meterReading.getPosActInstPower());
        assertEquals(1000, meterReading.getPosActEnergyTotal());
        assertEquals(50, meterReading.getNegActInstPower());
        assertEquals(500, meterReading.getNegActEnergyTotal());
        assertEquals(200, meterReading.getPosReactEnergyTotal());
        assertEquals(200, meterReading.getNegReactEnergyTotal());
        assertEquals(150, meterReading.getSumActInstantPower());
        assertEquals(10.5f, meterReading.getInstCurr_l1(), 0.001);
        assertEquals(220.0f, meterReading.getInstVolt_l1(), 0.001);
        assertEquals(20.0f, meterReading.getInstCurr_l2(), 0.001);
        assertEquals(230.0f, meterReading.getInstVolt_l2(), 0.001);
        assertEquals(30.0f, meterReading.getInstCurr_l3(), 0.001);
        assertNotNull(meterReading.getMeterId());
    }
}
