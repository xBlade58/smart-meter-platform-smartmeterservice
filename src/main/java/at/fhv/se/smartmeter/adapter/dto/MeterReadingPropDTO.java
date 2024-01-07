package at.fhv.se.smartmeter.adapter.dto;

import lombok.Getter;

@Getter
public class MeterReadingPropDTO {
    
    private String obisCode;
    private float value;
    //TODO: add unit as attribute?
    public MeterReadingPropDTO(String obisCode, float value) {
        this.obisCode = obisCode;
        this.value = value;
    }
    

}
