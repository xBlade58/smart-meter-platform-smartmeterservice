package at.fhv.se.platform.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @author Justin Ströhle
 * 16.11.2023
 */

@Entity
public class SmartMeter {

    @Id
    private int id;
    private String manufacturer;

    public SmartMeter(){}

    public SmartMeter(int id, String manufacturer) {
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
