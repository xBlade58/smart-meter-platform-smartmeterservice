package at.fhv.se.smartmeter.domain.model;

public enum MeterClass {
    ELECTRICITY("Electricity"),
    WATER("Water"),
    GAS("Gas"),
    HEAT("Heat");

    private String meterClass;

    MeterClass(String meterClass){
        this.meterClass = meterClass;
    }

    public String getValue() {
        return meterClass;
    }
    
}
