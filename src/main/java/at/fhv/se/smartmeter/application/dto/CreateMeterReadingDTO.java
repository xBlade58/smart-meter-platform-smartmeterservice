package at.fhv.se.smartmeter.application.dto;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class CreateMeterReadingDTO {
    private String readingTime;
    private String meterId;
    private MeterReadingPropDTO[] propertyValues;
}
