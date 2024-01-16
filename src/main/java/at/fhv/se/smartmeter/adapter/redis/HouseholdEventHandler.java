package at.fhv.se.smartmeter.adapter.redis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import at.fhv.se.smartmeter.adapter.redis.events.EventVisitor;
import at.fhv.se.smartmeter.adapter.redis.events.HouseholdEvent;
import at.fhv.se.smartmeter.adapter.redis.events.MeterAssignedEvent;
import at.fhv.se.smartmeter.adapter.redis.events.MeterUnassignedEvent;
import at.fhv.se.smartmeter.application.port.outbound.persistence.MeterRepository;

@Service
public class HouseholdEventHandler {

    private ObjectMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    @Autowired
    private MeterRepository meterRepository;
    
    public void handle(Map<String, String> messageBody) throws JsonProcessingException, IllegalArgumentException {

        HouseholdEvent ev =  deserializeEvent(messageBody);
        ev.accept(new EventVisitor() {

            @Override
            public void visit(MeterAssignedEvent ev) {
                
            }

            @Override
            public void visit(MeterUnassignedEvent ev) {
                // TODO Auto-generated method stub
                
            }
            
        });
        
    }

    private HouseholdEvent deserializeEvent(Map<String, String> messageBody) throws JsonProcessingException, IllegalArgumentException {
        JsonNode node =  objectMapper.readTree(objectMapper.writeValueAsString(messageBody));
        return objectMapper.treeToValue(node, HouseholdEvent.class);
    }
}
