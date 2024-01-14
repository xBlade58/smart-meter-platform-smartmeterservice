package at.fhv.se.smartmeter.adapter.timescaledb.model;

import java.util.UUID;

import at.fhv.se.smartmeter.domain.model.MeterClass;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "physical_meter")
public class PhysicalMeterDBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name; // Kaifa
    private String version; // MA309M
    
    @Enumerated(EnumType.STRING)
    private MeterClass meterClass; // ELECTRICITY

    public PhysicalMeterDBEntity(UUID id, String name, String version, MeterClass meterClass) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.meterClass = meterClass;
    }
    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public MeterClass getMeterClass() {
        return meterClass;
    }
    public void setMeterClass(MeterClass meterClass) {
        this.meterClass = meterClass;
    }

    public PhysicalMeterDBEntity() {}

    

}
