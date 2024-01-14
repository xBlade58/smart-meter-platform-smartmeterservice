package at.fhv.se.smartmeter.adapter.timescaledb.mapper;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.Type;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "meter_reading")
public class MeterReadingDBEntity {

    @Id
    private UUID id;
    private ZonedDateTime readingTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meter_id")
    private MeterDBEntity meterDBEntity;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<PropertyValueDBValue> jsonProperties;

    public MeterReadingDBEntity(UUID id, ZonedDateTime timestamp,
            List<PropertyValueDBValue> jsonProperties) {
        this.id = id;
        this.readingTime = timestamp;
        this.jsonProperties = jsonProperties;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ZonedDateTime getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(ZonedDateTime timestamp) {
        this.readingTime = timestamp;
    }

    public MeterDBEntity getMeterDBEntity() {
        return meterDBEntity;
    }

    public void setMeterDBEntity(MeterDBEntity meterDBEntity) {
        this.meterDBEntity = meterDBEntity;
    }

    public List<PropertyValueDBValue> getJsonProperties() {
        return jsonProperties;
    }

    public void setJsonProperties(List<PropertyValueDBValue> jsonProperties) {
        this.jsonProperties = jsonProperties;
    }

    private MeterReadingDBEntity() {
    }

    
    
}
