package at.fhv.se.smartmeter.domain.model;

public class PhysicalMeter {
    
    private String id;
    private String name; // Kaifa
    private String version; // MA309M
    private MeterClass meterClass; // ELECTRICITY

    public PhysicalMeter(String id, String name, String version, MeterClass meterClass) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.meterClass = meterClass;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public MeterClass getMeterClass() {
        return meterClass;
    }
  
}
