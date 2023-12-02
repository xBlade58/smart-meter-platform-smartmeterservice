package at.fhv.se.platform.adapter.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Justin Ströhle
 * 23.11.2023
 */

@Getter
@Builder
public class MeterReadingDTO {
    private Timestamp timestamp;
    private int meterId;
    private int posActInstPower; // 1.7.0
    private int posActEnergyTotal; // 1.8.0
    private int negActInstPower; // 2.7.0
    private int negActEnergyTotal; // 2.8.0
    private int posReactEnergyTotal; // 3.8.0
    private int negReactEnergyTotal; // 4.8.0
    private int sumActInstantPower; // 16.7.0
    private float instCurrL1; // 31.7.0
    private float instVoltL1; // 32.7.0
    private float instCurrL2; // 51.7.0
    private float instVoltL2; // 52.7.0
    private float instCurrL3; // 71.7.0
    private float instVoltL3; // 72.7.0
}
