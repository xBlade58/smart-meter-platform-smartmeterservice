package at.fhv.se.smartmeter.application.dto;


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
