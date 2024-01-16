package at.fhv.se.smartmeter.adapter.redis.events;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.DiscriminatorType;


@Entity
@Table(name = "household_event")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "event_type", discriminatorType = DiscriminatorType.STRING)
public abstract class HouseholdEvent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "event_type", insertable = false, updatable = false)
    protected String eventType;
    protected String entityId;
    protected LocalDateTime timestamp;

    public Long getId() {
        return id;
    }

    public String getEntityId() {
        return entityId;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    

}
