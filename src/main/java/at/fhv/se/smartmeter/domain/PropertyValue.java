package at.fhv.se.smartmeter.domain;

import java.time.ZonedDateTime;

public class PropertyValue {
    private Unit unit;
    private ZonedDateTime date;
    private float numericalValue;
    private String operationalPropertyDefId;
    
    public PropertyValue(Unit unit, ZonedDateTime date, float numericalValue, String operationalPropertyDefId) {
        this.unit = unit;
        this.date = date;
        this.numericalValue = numericalValue;
        this.operationalPropertyDefId = operationalPropertyDefId;
    }

    public Unit getUnit() {
        return unit;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public float getNumericalValue() {
        return numericalValue;
    }

    public String getOperationalPropertyDefId() {
        return operationalPropertyDefId;
    }
   
}
