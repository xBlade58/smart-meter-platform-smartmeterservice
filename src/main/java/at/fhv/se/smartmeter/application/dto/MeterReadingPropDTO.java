package at.fhv.se.smartmeter.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MeterReadingPropDTO {
    
    private String operationalPropertyDef;
    private float value;
    private String unit;  

}
