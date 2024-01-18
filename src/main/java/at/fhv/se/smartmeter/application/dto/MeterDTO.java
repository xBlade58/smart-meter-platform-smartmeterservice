package at.fhv.se.smartmeter.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MeterDTO {
    private String id;
    private String physicalMeterId;
    private String serialNumber;
    private String houseoldId;
}
