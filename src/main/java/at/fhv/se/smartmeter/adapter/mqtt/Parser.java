package at.fhv.se.smartmeter.adapter.mqtt;

import java.util.ArrayList;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import at.fhv.se.smartmeter.application.dto.MeterReadingDTO;
import at.fhv.se.smartmeter.application.dto.MeterReadingPropDTO;

@Service
public class Parser {
    public MeterReadingDTO parse(Message<?> msg) throws JsonMappingException, JsonProcessingException {
        Object payload = msg.getPayload();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(payload.toString());
        JsonNode propertyValues = node.get("propertyValues");

        if (!propertyValues.isArray()) {
            return null; //TODO: throw exception
        }

        ArrayList<MeterReadingPropDTO> arrList = new ArrayList<>();

        for (JsonNode propNode : propertyValues) {
            arrList.add(MeterReadingPropDTO.builder()
                .operationalPropertyDef(propNode.get("propertyName").asText())
                .value(Float.parseFloat(propNode.get("numericalValue").asText()))
                .unit(propNode.get("unit").asText()).build());
        }
        
        MeterReadingDTO dto = MeterReadingDTO. builder()
            .readingTime(node.get("readingTime").asText())
            .meterId(node.get("meterId").asText())
            .propertyValues(arrList.toArray(new MeterReadingPropDTO[0]))
            .build();

        return dto;
    }
}
