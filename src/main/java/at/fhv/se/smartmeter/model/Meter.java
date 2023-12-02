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
    private String manufacturer;

    public Meter(){}

    public Meter(int id, String manufacturer) {
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
