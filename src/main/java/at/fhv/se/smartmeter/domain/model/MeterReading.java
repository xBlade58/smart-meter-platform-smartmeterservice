package at.fhv.se.smartmeter.domain.model;

import java.time.ZonedDateTime;

public class MeterReading {
    private String id;
    private ZonedDateTime readingTime;
    private String meterIndividualId;

    private PropertyValue posActInstPower; // 1.7.0
    private PropertyValue posActEnergyTotal; // 1.8.0
    private PropertyValue negActInstPower; // 2.7.0
    private PropertyValue negActEnergyTotal; // 2.8.0
    private PropertyValue posReactEnergyTotal; // 3.8.0
    private PropertyValue negReactEnergyTotal; // 4.8.0
    private PropertyValue sumActInstantPower; // 16.7.0
    private PropertyValue instCurr_l1; // 31.7.0
    private PropertyValue instVolt_l1; // 32.7.0
    private PropertyValue instCurr_l2; // 51.7.0
    private PropertyValue instVolt_l2; // 52.7.0
    private PropertyValue instCurr_l3; // 71.7.0
    private PropertyValue instVolt_l3; // 72.7.0

    public MeterReading(String id, ZonedDateTime readingTime, String meterIndividualId, PropertyValue posActInstPower,
            PropertyValue posActEnergyTotal, PropertyValue negActInstPower, PropertyValue negActEnergyTotal,
            PropertyValue posReactEnergyTotal, PropertyValue negReactEnergyTotal, PropertyValue sumActInstantPower,
            PropertyValue instCurr_l1, PropertyValue instVolt_l1, PropertyValue instCurr_l2, PropertyValue instVolt_l2,
            PropertyValue instCurr_l3, PropertyValue instVolt_l3) {
        this.id = id;
        this.readingTime = readingTime;
        this.meterIndividualId = meterIndividualId;
        this.posActInstPower = posActInstPower;
        this.posActEnergyTotal = posActEnergyTotal;
        this.negActInstPower = negActInstPower;
        this.negActEnergyTotal = negActEnergyTotal;
        this.posReactEnergyTotal = posReactEnergyTotal;
        this.negReactEnergyTotal = negReactEnergyTotal;
        this.sumActInstantPower = sumActInstantPower;
        this.instCurr_l1 = instCurr_l1;
        this.instVolt_l1 = instVolt_l1;
        this.instCurr_l2 = instCurr_l2;
        this.instVolt_l2 = instVolt_l2;
        this.instCurr_l3 = instCurr_l3;
        this.instVolt_l3 = instVolt_l3;
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

    public PropertyValue getPosActInstPower() {
        return posActInstPower;
    }

    public PropertyValue getPosActEnergyTotal() {
        return posActEnergyTotal;
    }

    public PropertyValue getNegActInstPower() {
        return negActInstPower;
    }

    public PropertyValue getNegActEnergyTotal() {
        return negActEnergyTotal;
    }

    public PropertyValue getPosReactEnergyTotal() {
        return posReactEnergyTotal;
    }

    public PropertyValue getNegReactEnergyTotal() {
        return negReactEnergyTotal;
    }

    public PropertyValue getSumActInstantPower() {
        return sumActInstantPower;
    }

    public PropertyValue getInstCurr_l1() {
        return instCurr_l1;
    }

    public PropertyValue getInstVolt_l1() {
        return instVolt_l1;
    }

    public PropertyValue getInstCurr_l2() {
        return instCurr_l2;
    }

    public PropertyValue getInstVolt_l2() {
        return instVolt_l2;
    }

    public PropertyValue getInstCurr_l3() {
        return instCurr_l3;
    }

    public PropertyValue getInstVolt_l3() {
        return instVolt_l3;
    }
    
    
    

}

