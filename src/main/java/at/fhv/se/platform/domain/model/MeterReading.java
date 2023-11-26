package at.fhv.se.platform.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;

/**
 * @author Justin Ströhle
 * 16.11.2023
 */

@Entity
public class MeterReading {
    @Id
    private Timestamp timestamp;
    private int smartMeterId;
    private int posActInstPower; // 1.7.0
    private int posActEnergyTotal; // 1.8.0
    private int negActInstPower; // 2.7.0
    private int negActEnergyTotal; // 2.8.0
    private int posReactEnergyTotal; // 3.8.0
    private int negReactEnergyTotal; // 4.8.0
    private int sumActInstantPower; // 16.7.0
    private float instCurr_l1; // 31.7.0
    private float instVolt_l1; // 32.7.0
    private float instCurr_l2; // 51.7.0
    private float instVolt_l2; // 52.7.0
    private float instCurr_l3; // 71.7.0
    private float instVolt_l3; // 72.7.0

    public MeterReading(Timestamp timestamp, int smartMeterId, int posActInstPower, int posActEnergyTotal, int negActInstPower,
                        int negActEnergyTotal, int posReactEnergyTotal, int negReactEnergyTotal, int sumActInstantPower,
                        float instCurrL1, float instVoltL1, float instCurrL2, float instVoltL2, float instCurrL3,
                        float instVoltL3) {
        this.timestamp = timestamp;
        this.smartMeterId = smartMeterId;
        this.posActInstPower = posActInstPower;
        this.posActEnergyTotal = posActEnergyTotal;
        this.negActInstPower = negActInstPower;
        this.negActEnergyTotal = negActEnergyTotal;
        this.posReactEnergyTotal = posReactEnergyTotal;
        this.negReactEnergyTotal = negReactEnergyTotal;
        this.sumActInstantPower = sumActInstantPower;
        this.instCurr_l1 = instCurrL1;
        this.instVolt_l1 = instVoltL1;
        this.instCurr_l2 = instCurrL2;
        this.instVolt_l2 = instVoltL2;
        this.instCurr_l3 = instCurrL3;
        this.instVolt_l3 = instVoltL3;
    }

    public MeterReading() {
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

    public float getInstCurr_l1() {
        return instCurr_l1;
    }

    public float getInstVolt_l1() {
        return instVolt_l1;
    }

    public float getInstCurr_l2() {
        return instCurr_l2;
    }

    public float getInstVolt_l2() {
        return instVolt_l2;
    }

    public float getInstCurr_l3() {
        return instCurr_l3;
    }

    public float getInstVolt_l3() {
        return instVolt_l3;
    }

    public int getSmartMeterId(){
        return smartMeterId;
    }
}

