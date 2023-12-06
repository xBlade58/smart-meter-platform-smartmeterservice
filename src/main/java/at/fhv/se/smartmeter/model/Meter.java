package at.fhv.se.smartmeter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @author Justin Ströhle
 * 16.11.2023
 */

@Entity
public class Meter {

    @Id
    private int id;
    private int serialNumber;
    private String manufacturer;

    public Meter(){}

    public Meter(int serialNumber, String manufacturer) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
