package at.fhv.se.smartmeter.adapter.redis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import at.fhv.se.smartmeter.adapter.redis.events.EventVisitor;
import at.fhv.se.smartmeter.adapter.redis.events.HouseholdEvent;
import at.fhv.se.smartmeter.adapter.redis.events.MeterAssignedEvent;
import at.fhv.se.smartmeter.adapter.redis.events.MeterUnassignedEvent;
import at.fhv.se.smartmeter.application.port.inbound.meter.AssignHousoldToMeterUseCase;
import at.fhv.se.smartmeter.application.port.inbound.meter.GetMeterUseCase;
import at.fhv.se.smartmeter.application.port.inbound.meter.UnassignHouseholdFromMeterUseCase;

@Service
public class HouseholdEventHandler {

    private ObjectMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    @Autowired
    private AssignHousoldToMeterUseCase assignHouseholdUsecase;

    @Autowired
    private UnassignHouseholdFromMeterUseCase unassignHousehold;

    @Autowired
    private GetMeterUseCase getMeterUseCase;

    
    public void handle(Map<String, String> messageBody) throws JsonProcessingException, IllegalArgumentException {

        HouseholdEvent ev =  deserializeEvent(messageBody);
        ev.accept(new EventVisitor() {

            @Override
            public void visit(MeterAssignedEvent ev) {
                if (!getMeterUseCase.existsById(ev.getMeterId())) {
                    System.out.println("Ignoring event for household: " + ev.getEntityId());
                    return;
                }
                assignHouseholdUsecase.assign(ev.getMeterId(), ev.getEntityId());
            }

            @Override
            public void visit(MeterUnassignedEvent ev) {
                if (!getMeterUseCase.existsById(ev.getMeterId())) {
                    System.out.println("Ignoring event for household: " + ev.getEntityId());
                    return;
                }
                unassignHousehold.unassign(ev.getMeterId());
            }
            
        });
        
    }

    private HouseholdEvent deserializeEvent(Map<String, String> messageBody) throws JsonProcessingException, IllegalArgumentException {
        JsonNode node =  objectMapper.readTree(objectMapper.writeValueAsString(messageBody));
        return objectMapper.treeToValue(node, HouseholdEvent.class);
    }
}
