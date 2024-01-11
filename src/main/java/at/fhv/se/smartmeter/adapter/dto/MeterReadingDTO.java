package at.fhv.se.smartmeter.adapter.dto;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class MeterReadingDTO {
    private String readingTime;
    private String meterId;
    private MeterReadingPropDTO[] propertyValues;
}
