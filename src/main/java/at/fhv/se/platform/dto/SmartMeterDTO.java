package at.fhv.se.platform.dto;

/**
 * @author Justin Ströhle
 * 23.11.2023
 */

public class SmartMeterDTO {
    String id;
    String manufacturer;

    public SmartMeterDTO(String id, String manufacturer) {
        this.id = id;
        this.manufacturer = manufacturer;
    }

    public String getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
