package at.fhv.se.smartmeter.adapter.mqtt;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import at.fhv.se.smartmeter.adapter.dto.MeterReadingDTO;
import at.fhv.se.smartmeter.adapter.dto.MeterReadingPropDTO;

@Service
public class Parser {
    public MeterReadingDTO parse(Message<?> msg) {
        Object payload = msg.getPayload();
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(payload.toString());

            MeterReadingDTO dto = MeterReadingDTO.builder()
                .timestamp(node.get("timestamp").asText())
                .meterId("b52ac10f-58cc-6172-a567-0e02b2c3d479")
                .posActInstPower(new MeterReadingPropDTO("1.7.0", Float.parseFloat(node.get("1.7.0").asText())))
                .posActEnergyTotal(new MeterReadingPropDTO("1.8.0", Float.parseFloat(node.get("1.8.0").asText())))
                .negActInstPower(new MeterReadingPropDTO("2.7.0", Float.parseFloat(node.get("2.7.0").asText())))
                .negActEnergyTotal(new MeterReadingPropDTO("2.8.0", Float.parseFloat(node.get("2.8.0").asText())))
                .posReactEnergyTotal(new MeterReadingPropDTO("3.8.0", Float.parseFloat(node.get("3.8.0").asText())))
                .negReactEnergyTotal(new MeterReadingPropDTO("4.8.0", Float.parseFloat(node.get("4.8.0").asText())))
                .sumActInstantPower(new MeterReadingPropDTO("16.7.0", Float.parseFloat(node.get("16.7.0").asText())))
                .instCurrL1(new MeterReadingPropDTO("31.7.0", Float.parseFloat(node.get("31.7.0").asText())))
                .instVoltL1(new MeterReadingPropDTO("32.7.0", Float.parseFloat(node.get("32.7.0").asText())))
                .instCurrL2(new MeterReadingPropDTO("51.7.0", Float.parseFloat(node.get("51.7.0").asText())))
                .instVoltL2(new MeterReadingPropDTO("52.7.0", Float.parseFloat(node.get("52.7.0").asText())))
                .instCurrL3(new MeterReadingPropDTO("71.7.0", Float.parseFloat(node.get("71.7.0").asText())))
                .instVoltL3(new MeterReadingPropDTO("72.7.0", Float.parseFloat(node.get("72.7.0").asText())))
                .build();

            return dto;

        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null; //TODO: refactor return value in case empty
    }
}
