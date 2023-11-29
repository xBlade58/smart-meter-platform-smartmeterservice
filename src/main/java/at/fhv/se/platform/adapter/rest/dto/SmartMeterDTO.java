package at.fhv.se.platform.adapter.rest.dto;

/**
 * @author Justin Ströhle
 * 23.11.2023
 */

public class SmartMeterDTO {
    int id;
    String manufacturer;

    public SmartMeterDTO(int id, String manufacturer) {
        this.id = id;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
