package at.fhv.se.smartmeter.adapter.redis.events;

public class MeterAssignedEvent extends HouseholdEvent {
    
    private String meterId;

    public MeterAssignedEvent(String meterId) {
        super();
        this.meterId = meterId;
        this.eventType = "MeterAssignedEvent";
    }



    public String getMeterId() {
        return meterId;
    }

    
}
