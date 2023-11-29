package at.fhv.se.platform.adapter.rest.dto;

import java.sql.Timestamp;

/**
 * @author Justin Ströhle
 * 23.11.2023
 */

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

    public MeterReadingDTO(Timestamp timestamp, int meterId, int posActInstPower, int posActEnergyTotal, int negActInstPower,
                           int negActEnergyTotal, int posReactEnergyTotal, int negReactEnergyTotal,
                           int sumActInstantPower, float instCurrL1, float instVoltL1, float instCurrL2,
                           float instVoltL2, float instCurrL3, float instVoltL3) {
        this.timestamp = timestamp;
        this.meterId = meterId;
        this.posActInstPower = posActInstPower;
        this.posActEnergyTotal = posActEnergyTotal;
        this.negActInstPower = negActInstPower;
        this.negActEnergyTotal = negActEnergyTotal;
        this.posReactEnergyTotal = posReactEnergyTotal;
        this.negReactEnergyTotal = negReactEnergyTotal;
        this.sumActInstantPower = sumActInstantPower;
        this.instCurrL1 = instCurrL1;
        this.instVoltL1 = instVoltL1;
        this.instCurrL2 = instCurrL2;
        this.instVoltL2 = instVoltL2;
        this.instCurrL3 = instCurrL3;
        this.instVoltL3 = instVoltL3;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public int getPosActInstPower() {
        return posActInstPower;
    }

    public int getPosActEnergyTotal() {
        return posActEnergyTotal;
    }

    public int getNegActInstPower() {
        return negActInstPower;
    }

    public int getNegActEnergyTotal() {
        return negActEnergyTotal;
    }

    public int getPosReactEnergyTotal() {
        return posReactEnergyTotal;
    }

    public int getNegReactEnergyTotal() {
        return negReactEnergyTotal;
    }

    public int getSumActInstantPower() {
        return sumActInstantPower;
    }

    public float getInstCurrL1() {
        return instCurrL1;
    }

    public float getInstVoltL1() {
        return instVoltL1;
    }

    public float getInstCurrL2() {
        return instCurrL2;
    }

    public float getInstVoltL2() {
        return instVoltL2;
    }

    public float getInstCurrL3() {
        return instCurrL3;
    }

    public float getInstVoltL3() {
        return instVoltL3;
    }
    
    public int getMeterId(){
        return meterId;
    }
}
