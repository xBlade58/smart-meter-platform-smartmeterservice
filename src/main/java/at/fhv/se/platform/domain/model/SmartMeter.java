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
    private String id;
    private String manufacturer;
}
