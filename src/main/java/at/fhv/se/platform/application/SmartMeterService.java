package at.fhv.se.platform.application;

import at.fhv.se.platform.dto.SmartMeterDTO;

import java.util.List;

/**
 * @author Justin Ströhle
 * 22.11.2023
 */

public interface SmartMeterService {
    int createSmartMeter(int id, String manufacturer);
    List<SmartMeterDTO> getAllSmartMeters();

}
