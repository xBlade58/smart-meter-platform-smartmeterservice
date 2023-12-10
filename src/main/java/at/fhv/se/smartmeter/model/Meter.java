package at.fhv.se.smartmeter.model;

/**
 * @author Justin Ströhle
 * 16.11.2023
 */



public class Meter {

    private long id;
    private int serialNumber;
    private String manufacturer;

    public Meter(){}

    public Meter(int serialNumber, String manufacturer) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
    }

    public long getId() {
        return id;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
