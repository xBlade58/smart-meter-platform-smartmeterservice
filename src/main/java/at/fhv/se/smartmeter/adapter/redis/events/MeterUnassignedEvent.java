package at.fhv.se.smartmeter.adapter.redis.events;

public class MeterUnassignedEvent extends HouseholdEvent {

    private String meterId;

    public MeterUnassignedEvent(String meterId) {
        super();
        this.meterId = meterId;
        this.eventType = "MeterUnassignedEvent";
        this.meterId = meterId;
    }

    public String getMeterId() {
        return meterId;
    }

    

    
}
