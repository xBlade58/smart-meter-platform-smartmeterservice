package at.fhv.se.smartmeter.adapter.mqtt;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import at.fhv.se.smartmeter.adapter.dto.MeterReadingDTO;

@Service
public class Parser {
    public MeterReadingDTO parse(Message<?> msg) {
        Object payload = msg.getPayload();
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(payload.toString());

            MeterReadingDTO dto = MeterReadingDTO.builder()
                .timestamp(node.get("timestamp").asText())
                .meterId("5edc6d29-17c3-4a9f-b13e-08b9d5a61a38")
                .posActInstPower(Integer.parseInt(node.get("1.7.0").asText()))
                .posActEnergyTotal(Integer.parseInt(node.get("1.8.0").asText()))
                .negActInstPower(Integer.parseInt(node.get("2.7.0").asText()))
                .negActEnergyTotal(Integer.parseInt(node.get("2.8.0").asText()))
                .posReactEnergyTotal(Integer.parseInt(node.get("3.8.0").asText()))
                .negReactEnergyTotal(Integer.parseInt(node.get("4.8.0").asText()))
                .sumActInstantPower(Integer.parseInt(node.get("16.7.0").asText()))
                .instCurrL1(Float.parseFloat(node.get("31.7.0").asText()))
                .instVoltL1(Float.parseFloat(node.get("32.7.0").asText()))
                .instCurrL2(Float.parseFloat(node.get("51.7.0").asText()))
                .instVoltL2(Float.parseFloat(node.get("52.7.0").asText()))
                .instCurrL3(Float.parseFloat(node.get("71.7.0").asText()))
                .instVoltL3(Float.parseFloat(node.get("72.7.0").asText()))
                .build();

            return dto;

        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null; //TODO: refactor return value in case empty
    }
}
