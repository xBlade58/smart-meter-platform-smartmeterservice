package at.fhv.se.smartmeter.adapter.timescaledb.mapper;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "meter_reading")
public class MeterReadingDBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private ZonedDateTime timestamp;
    private UUID meterId;
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

    public MeterReadingDBEntity(ZonedDateTime timestamp, UUID meterId, int posActInstPower, int posActEnergyTotal,
            int negActInstPower, int negActEnergyTotal, int posReactEnergyTotal, int negReactEnergyTotal,
            int sumActInstantPower, float instCurr_l1, float instVolt_l1, float instCurr_l2, float instVolt_l2,
            float instCurr_l3, float instVolt_l3) {
        this.timestamp = timestamp;
        this.meterId = meterId;
        this.posActInstPower = posActInstPower;
        this.posActEnergyTotal = posActEnergyTotal;
        this.negActInstPower = negActInstPower;
        this.negActEnergyTotal = negActEnergyTotal;
        this.posReactEnergyTotal = posReactEnergyTotal;
        this.negReactEnergyTotal = negReactEnergyTotal;
        this.sumActInstantPower = sumActInstantPower;
        this.instCurr_l1 = instCurr_l1;
        this.instVolt_l1 = instVolt_l1;
        this.instCurr_l2 = instCurr_l2;
        this.instVolt_l2 = instVolt_l2;
        this.instCurr_l3 = instCurr_l3;
        this.instVolt_l3 = instVolt_l3;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public UUID getMeterId() {
        return meterId;
    }

    public void setMeterId(UUID meterId) {
        this.meterId = meterId;
    }

    public int getPosActInstPower() {
        return posActInstPower;
    }

    public void setPosActInstPower(int posActInstPower) {
        this.posActInstPower = posActInstPower;
    }

    public int getPosActEnergyTotal() {
        return posActEnergyTotal;
    }

    public void setPosActEnergyTotal(int posActEnergyTotal) {
        this.posActEnergyTotal = posActEnergyTotal;
    }

    public int getNegActInstPower() {
        return negActInstPower;
    }

    public void setNegActInstPower(int negActInstPower) {
        this.negActInstPower = negActInstPower;
    }

    public int getNegActEnergyTotal() {
        return negActEnergyTotal;
    }

    public void setNegActEnergyTotal(int negActEnergyTotal) {
        this.negActEnergyTotal = negActEnergyTotal;
    }

    public int getPosReactEnergyTotal() {
        return posReactEnergyTotal;
    }

    public void setPosReactEnergyTotal(int posReactEnergyTotal) {
        this.posReactEnergyTotal = posReactEnergyTotal;
    }

    public int getNegReactEnergyTotal() {
        return negReactEnergyTotal;
    }

    public void setNegReactEnergyTotal(int negReactEnergyTotal) {
        this.negReactEnergyTotal = negReactEnergyTotal;
    }

    public int getSumActInstantPower() {
        return sumActInstantPower;
    }

    public void setSumActInstantPower(int sumActInstantPower) {
        this.sumActInstantPower = sumActInstantPower;
    }

    public float getInstCurr_l1() {
        return instCurr_l1;
    }

    public void setInstCurr_l1(float instCurr_l1) {
        this.instCurr_l1 = instCurr_l1;
    }

    public float getInstVolt_l1() {
        return instVolt_l1;
    }

    public void setInstVolt_l1(float instVolt_l1) {
        this.instVolt_l1 = instVolt_l1;
    }

    public float getInstCurr_l2() {
        return instCurr_l2;
    }

    public void setInstCurr_l2(float instCurr_l2) {
        this.instCurr_l2 = instCurr_l2;
    }

    public float getInstVolt_l2() {
        return instVolt_l2;
    }

    public void setInstVolt_l2(float instVolt_l2) {
        this.instVolt_l2 = instVolt_l2;
    }

    public float getInstCurr_l3() {
        return instCurr_l3;
    }

    public void setInstCurr_l3(float instCurr_l3) {
        this.instCurr_l3 = instCurr_l3;
    }

    public float getInstVolt_l3() {
        return instVolt_l3;
    }

    public void setInstVolt_l3(float instVolt_l3) {
        this.instVolt_l3 = instVolt_l3;
    }

    private MeterReadingDBEntity(){}

    
}
