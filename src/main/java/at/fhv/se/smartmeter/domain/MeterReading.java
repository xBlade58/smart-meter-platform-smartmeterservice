package at.fhv.se.smartmeter.domain;

import java.time.ZonedDateTime;
import java.util.List;

public class MeterReading {

    private String id;
    private ZonedDateTime readingTime;
    private String meterIndividualId;
    private List<PropertyValue> propertyValues;

    public MeterReading(String id, ZonedDateTime readingTime, String meterIndividualId,
            List<PropertyValue> propertyValues) {
        this.id = id;
        this.readingTime = readingTime;
        this.meterIndividualId = meterIndividualId;
        this.propertyValues = propertyValues;
    }

    public String getId() {
        return id;
    }

    public ZonedDateTime getReadingTime() {
        return readingTime;
    }

    public String getMeterIndividualId() {
        return meterIndividualId;
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }
    

}

