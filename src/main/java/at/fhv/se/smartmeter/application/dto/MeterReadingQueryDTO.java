package at.fhv.se.smartmeter.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MeterReadingQueryDTO {
    private String id;
    private String readingTime;
    private String meterId;
    private MeterReadingPropDTO[] propertyValues;
}
