package at.fhv.se.smartmeter.adapter.redis.events;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "eventType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MeterAssignedEvent.class, name = "MeterAssignedEvent"),
        @JsonSubTypes.Type(value = MeterUnassignedEvent.class, name = "MeterUnassignedEvent")
})
public abstract class HouseholdEvent {
    
    private Long id;
    protected String eventType;
    protected String entityId;
    protected LocalDateTime timestamp;

    public HouseholdEvent(String entityId, LocalDateTime timestamp) {
        this.eventType = this.getClass().getSimpleName();
        this.entityId = entityId;
        this.timestamp = timestamp;
    }

    public abstract void accept(EventVisitor visitor);

    public Long getId() {
        return id;
    }

    public String getEntityId() {
        return entityId;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public HouseholdEvent() {}

}
