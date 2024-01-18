package at.fhv.se.smartmeter.adapter.redis.events;

public class MeterUnassignedEvent extends HouseholdEvent {

    private String meterId;

    public MeterUnassignedEvent(String meterId) {
        super();
        this.meterId = meterId;
        this.eventType = "MeterUnassignedEvent";
        this.meterId = meterId;
    }

    @Override
    public void accept(EventVisitor visitor) {
        visitor.visit(this);
    }

    public String getMeterId() {
        return meterId;
    }

    private MeterUnassignedEvent() {}    

    
}
