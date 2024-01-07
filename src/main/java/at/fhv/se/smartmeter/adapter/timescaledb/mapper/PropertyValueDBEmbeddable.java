package at.fhv.se.smartmeter.adapter.timescaledb.mapper;

import java.time.ZonedDateTime;

import at.fhv.se.smartmeter.domain.model.Unit;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class PropertyValueDBEmbeddable {
    
    @Enumerated(EnumType.STRING)
    private Unit unit;
    private ZonedDateTime date;
    private float numericalValue;
    private String operationalPropertyDefId;
    
    public PropertyValueDBEmbeddable(Unit unit, ZonedDateTime date, float numericalValue, String operationalPropertyDefId) {
        this.unit = unit;
        this.date = date;
        this.numericalValue = numericalValue;
        this.operationalPropertyDefId = operationalPropertyDefId;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public float getNumericalValue() {
        return numericalValue;
    }

    public void setNumericalValue(float numericalValue) {
        this.numericalValue = numericalValue;
    }

    public String getOperationalPropertyDefId() {
        return operationalPropertyDefId;
    }

    public void setOperationalPropertyDefId(String operationalPropertyDefId) {
        this.operationalPropertyDefId = operationalPropertyDefId;
    }

    
}
