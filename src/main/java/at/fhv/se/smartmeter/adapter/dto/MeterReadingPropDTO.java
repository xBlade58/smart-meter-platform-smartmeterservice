package at.fhv.se.smartmeter.adapter.dto;

import lombok.Getter;

@Getter
public class MeterReadingPropDTO {
    
    private String operationalPropertyDef;
    private float value;
    private String unit;
    //TODO: add unit as attribute?
    public MeterReadingPropDTO(String operationalPropertyDef, float value, String unit) {
        this.operationalPropertyDef = operationalPropertyDef;
        this.value = value;
        this.unit = unit;
    }
   

}
