package at.fhv.se.smartmeter.adapter.timescaledb.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class PropertyValueDBValue implements Serializable {
    //TODO: change type to UNIT
    private String unit;
    private ZonedDateTime date;
    private float numericalValue;
    private String operationalPropertyDefId;
    
    public PropertyValueDBValue(String unit, ZonedDateTime date, float numericalValue, String operationalPropertyDefId) {
        this.unit = unit;
        this.date = date;
        this.numericalValue = numericalValue;
        this.operationalPropertyDefId = operationalPropertyDefId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
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

    @Override
    public String toString() {
        return "PropertyValueDBValue [unit=" + unit + ", date=" + date + ", numericalValue=" + numericalValue
                + ", operationalPropertyDefId=" + operationalPropertyDefId + "]";
    }

    private PropertyValueDBValue() {}
  
    
    
}
