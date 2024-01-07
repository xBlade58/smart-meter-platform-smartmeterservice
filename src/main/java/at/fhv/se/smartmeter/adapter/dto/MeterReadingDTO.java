package at.fhv.se.smartmeter.adapter.dto;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class MeterReadingDTO {
    private String timestamp;
    private String meterId;
    private MeterReadingPropDTO posActInstPower; // 1.7.0
    private MeterReadingPropDTO posActEnergyTotal; // 1.8.0
    private MeterReadingPropDTO negActInstPower; // 2.7.0
    private MeterReadingPropDTO negActEnergyTotal; // 2.8.0
    private MeterReadingPropDTO posReactEnergyTotal; // 3.8.0
    private MeterReadingPropDTO negReactEnergyTotal; // 4.8.0
    private MeterReadingPropDTO sumActInstantPower; // 16.7.0
    private MeterReadingPropDTO instCurrL1; // 31.7.0
    private MeterReadingPropDTO instVoltL1; // 32.7.0
    private MeterReadingPropDTO instCurrL2; // 51.7.0
    private MeterReadingPropDTO instVoltL2; // 52.7.0
    private MeterReadingPropDTO instCurrL3; // 71.7.0
    private MeterReadingPropDTO instVoltL3; // 72.7.0
}
