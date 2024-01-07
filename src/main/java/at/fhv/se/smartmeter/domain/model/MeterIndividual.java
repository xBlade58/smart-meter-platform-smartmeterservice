package at.fhv.se.smartmeter.domain.model;


public class MeterIndividual {

    private String id;
    private String physicalMeterId;
    private String serialNumber;

    public MeterIndividual(){}

    public MeterIndividual(String serialNumber, String physicalMeterId) {
        this.serialNumber = serialNumber;
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
