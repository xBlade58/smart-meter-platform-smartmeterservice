package at.fhv.se.smartmeter.adapter.redis.events;

import java.time.LocalDateTime;

public class MeterAssignedEvent extends HouseholdEvent {
    
    private String meterId;

    public MeterAssignedEvent(String entityId, LocalDateTime timestamp, String meterId) {
        super(entityId, timestamp);
        this.meterId = meterId;
    }

    @Override
    public void accept(EventVisitor visitor) {
        visitor.visit(this);
    }

    public String getMeterId() {
        return meterId;
    }

    private MeterAssignedEvent() {}

    
}
