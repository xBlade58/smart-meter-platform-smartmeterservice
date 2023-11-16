package at.fhv.se.platform.domain.model;

import java.sql.Timestamp;

/**
 * @author Justin Ströhle
 * 16.11.2023
 */

public class MeterRecord {
    private Timestamp timestamp;
    private int posActInstPower; // 1.7.0
    private int posActEnergyTotal; // 1.8.0
    private int negActInstPower; // 2.7.0
    private int negActEnergyTotal; // 2.8.0
    private int posReactEnergyTotal; // 3.8.0
    private int negReactEnergyTotal; // 4.8.0
    private int sumActInstantPower; // 16.7.0
    private double instCurrL1; // 31.7.0
    private double instVoltL1; // 32.7.0
    private double instCurrL2; // 51.7.0
    private double instVoltL2; // 52.7.0
    private double instCurrL3; // 71.7.0
    private double instVoltL3; // 72.7.0
}
