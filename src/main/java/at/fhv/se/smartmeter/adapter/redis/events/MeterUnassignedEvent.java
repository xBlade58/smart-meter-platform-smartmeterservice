package at.fhv.se.smartmeter.adapter.redis.events;

import java.time.LocalDateTime;

public class MeterUnassignedEvent extends HouseholdEvent {

    private String meterId;

    public MeterUnassignedEvent(String id, String meterId, LocalDateTime timestamp) {
        super(id, meterId, timestamp);
        this.meterId = meterId;
        this.eventType = "MeterUnassignedEvent";
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
