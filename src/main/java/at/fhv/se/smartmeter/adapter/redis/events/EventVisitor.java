package at.fhv.se.smartmeter.adapter.redis.events;

public interface EventVisitor {
    void visit(MeterAssignedEvent ev);
    void visit(MeterUnassignedEvent ev);
}
