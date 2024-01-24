package at.fhv.se.smartmeter.domain;


public class MeterIndividual {

    private String id;
    private String physicalMeterId;
    private String serialNumber;
    private String houseoldId;

    //public MeterIndividual(){}

    public MeterIndividual(String serialNumber, String physicalMeterId, String householdId) {
        this.serialNumber = serialNumber;
        this.physicalMeterId = physicalMeterId;
        this.houseoldId = householdId;
    }

    public MeterIndividual(String id, String serialNumber, String physicalMeterId, String householdId) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.physicalMeterId = physicalMeterId;
        this.houseoldId = householdId;
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
    
    public String getHouseoldId() {
        return houseoldId;
    }



    
}
