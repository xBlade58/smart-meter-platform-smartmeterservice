package at.fhv.se.smartmeter.adapter.timescaledb.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "meter")
public class MeterDBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String serialNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "physical_meter_id")
    private PhysicalMeterDBEntity physicalMeter;
    
    private String householdId;

    public MeterDBEntity(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public MeterDBEntity(){}



    public UUID getId() {
        return id;
    }



    public void setId(UUID id) {
        this.id = id;
    }



    public String getSerialNumber() {
        return serialNumber;
    }



    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }



    public PhysicalMeterDBEntity getPhysicalMeter() {
        return physicalMeter;
    }



    public void setPhysicalMeter(PhysicalMeterDBEntity physicalMeter) {
        this.physicalMeter = physicalMeter;
    }

    public String getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }
  

}
