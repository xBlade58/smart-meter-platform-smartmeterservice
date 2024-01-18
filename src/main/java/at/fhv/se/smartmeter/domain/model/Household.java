package at.fhv.se.smartmeter.domain.model;

import java.util.List;

public class Household {
    private String id;
    private List<String> meterIds;

    public Household(String id, List<String> meterIds) {
        this.id = id;
        this.meterIds = meterIds;
    }

    public String getId() {
        return id;
    }

    public List<String> getMeterIds() {
        return meterIds;
    }

    
}
