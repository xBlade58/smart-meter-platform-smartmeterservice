package at.fhv.se.platform.adapter.mqtt;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import at.fhv.se.platform.adapter.dto.MeterReadingDTO;

@Service
public class Parser {
    public MeterReadingDTO parse(Message<?> msg) {
        Object payload = msg.getPayload();
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(payload.toString());
            JsonNode acutalMsgNode = node.get("message");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

            MeterReadingDTO dto = MeterReadingDTO.builder()
                .timestamp(Timestamp.valueOf(LocalDateTime.parse(acutalMsgNode.get("timestamp").asText(), formatter)))
                .meterId(5)
                .posActInstPower(Integer.parseInt(acutalMsgNode.get("1.7.0").asText()))
                .posActEnergyTotal(Integer.parseInt(acutalMsgNode.get("1.8.0").asText()))
                .negActInstPower(Integer.parseInt(acutalMsgNode.get("2.7.0").asText()))
                .negActEnergyTotal(Integer.parseInt(acutalMsgNode.get("2.8.0").asText()))
                .posReactEnergyTotal(Integer.parseInt(acutalMsgNode.get("3.8.0").asText()))
                .negReactEnergyTotal(Integer.parseInt(acutalMsgNode.get("4.8.0").asText()))
                .sumActInstantPower(Integer.parseInt(acutalMsgNode.get("16.7.0").asText()))
                .instCurrL1(Float.parseFloat(acutalMsgNode.get("31.7.0").asText()))
                .instVoltL1(Float.parseFloat(acutalMsgNode.get("32.7.0").asText()))
                .instCurrL2(Float.parseFloat(acutalMsgNode.get("51.7.0").asText()))
                .instVoltL2(Float.parseFloat(acutalMsgNode.get("52.7.0").asText()))
                .instCurrL3(Float.parseFloat(acutalMsgNode.get("71.7.0").asText()))
                .instVoltL3(Float.parseFloat(acutalMsgNode.get("72.7.0").asText()))
                .build();

            return dto;

        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null; //TODO: refactor return value in case empty
    }
}
