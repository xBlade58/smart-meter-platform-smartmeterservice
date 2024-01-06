package at.fhv.se.smartmeter.domain.model;


public class MeterIndividual {

    private String id;
    private String physicalMeterId;
    private String serialNumber;

    public MeterIndividual(){}

    public MeterIndividual(String name, String physicalMeterId) {
        this.serialNumber = name;
        this.physicalMeterId = physicalMeterId;
    }

    public String getId() {
        return id;
    }

    public String getPhysicalMeterId() {
        return physicalMeterId;
    }
    
    public String getSerialNumber() {
        return serialNumber;
    }



    
}
