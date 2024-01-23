package at.fhv.se.smartmeter.domain;

public class OperationalPropertyDef {

    private String id; // OBIS Code, e.g. 1.7.0
    private String name; // e.g. posActInstPower
    private Unit[] allowedUnits;
    
    public OperationalPropertyDef(String id, String name, Unit[] allowedUnits) {
        this.id = id;
        this.name = name;
        this.allowedUnits = allowedUnits;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Unit[] getAllowedUnits() {
        return allowedUnits;
    }
   
}
