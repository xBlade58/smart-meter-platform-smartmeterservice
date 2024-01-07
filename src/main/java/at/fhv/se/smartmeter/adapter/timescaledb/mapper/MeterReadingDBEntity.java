package at.fhv.se.smartmeter.adapter.timescaledb.mapper;

import java.time.ZonedDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "meter_reading")
public class MeterReadingDBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private ZonedDateTime timestamp;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meter_id")
    private MeterDBEntity meterDBEntity;
    private PropertyValueDBEmbeddable posActInstPower; // 1.7.0
    private PropertyValueDBEmbeddable posActEnergyTotal; // 1.8.0
    private PropertyValueDBEmbeddable negActInstPower; // 2.7.0
    private PropertyValueDBEmbeddable negActEnergyTotal; // 2.8.0
    private PropertyValueDBEmbeddable posReactEnergyTotal; // 3.8.0
    private PropertyValueDBEmbeddable negReactEnergyTotal; // 4.8.0
    private PropertyValueDBEmbeddable sumActInstantPower; // 16.7.0
    private PropertyValueDBEmbeddable instCurr_l1; // 31.7.0
    private PropertyValueDBEmbeddable instVolt_l1; // 32.7.0
    private PropertyValueDBEmbeddable instCurr_l2; // 51.7.0
    private PropertyValueDBEmbeddable instVolt_l2; // 52.7.0
    private PropertyValueDBEmbeddable instCurr_l3; // 71.7.0
    private PropertyValueDBEmbeddable instVolt_l3; // 72.7.0

    public MeterReadingDBEntity(ZonedDateTime timestamp,
            PropertyValueDBEmbeddable posActInstPower, PropertyValueDBEmbeddable posActEnergyTotal,
            PropertyValueDBEmbeddable negActInstPower, PropertyValueDBEmbeddable negActEnergyTotal,
            PropertyValueDBEmbeddable posReactEnergyTotal, PropertyValueDBEmbeddable negReactEnergyTotal,
            PropertyValueDBEmbeddable sumActInstantPower, PropertyValueDBEmbeddable instCurr_l1,
            PropertyValueDBEmbeddable instVolt_l1, PropertyValueDBEmbeddable instCurr_l2,
            PropertyValueDBEmbeddable instVolt_l2, PropertyValueDBEmbeddable instCurr_l3,
            PropertyValueDBEmbeddable instVolt_l3) {
        this.timestamp = timestamp;
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




    private MeterReadingDBEntity(){}




    public UUID getId() {
        return id;
    }




    public void setId(UUID id) {
        this.id = id;
    }




    public ZonedDateTime getTimestamp() {
        return timestamp;
    }




    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }



    public PropertyValueDBEmbeddable getPosActInstPower() {
        return posActInstPower;
    }




    public void setPosActInstPower(PropertyValueDBEmbeddable posActInstPower) {
        this.posActInstPower = posActInstPower;
    }




    public PropertyValueDBEmbeddable getPosActEnergyTotal() {
        return posActEnergyTotal;
    }




    public void setPosActEnergyTotal(PropertyValueDBEmbeddable posActEnergyTotal) {
        this.posActEnergyTotal = posActEnergyTotal;
    }




    public PropertyValueDBEmbeddable getNegActInstPower() {
        return negActInstPower;
    }




    public void setNegActInstPower(PropertyValueDBEmbeddable negActInstPower) {
        this.negActInstPower = negActInstPower;
    }




    public PropertyValueDBEmbeddable getNegActEnergyTotal() {
        return negActEnergyTotal;
    }




    public void setNegActEnergyTotal(PropertyValueDBEmbeddable negActEnergyTotal) {
        this.negActEnergyTotal = negActEnergyTotal;
    }




    public PropertyValueDBEmbeddable getPosReactEnergyTotal() {
        return posReactEnergyTotal;
    }




    public void setPosReactEnergyTotal(PropertyValueDBEmbeddable posReactEnergyTotal) {
        this.posReactEnergyTotal = posReactEnergyTotal;
    }




    public PropertyValueDBEmbeddable getNegReactEnergyTotal() {
        return negReactEnergyTotal;
    }




    public void setNegReactEnergyTotal(PropertyValueDBEmbeddable negReactEnergyTotal) {
        this.negReactEnergyTotal = negReactEnergyTotal;
    }




    public PropertyValueDBEmbeddable getSumActInstantPower() {
        return sumActInstantPower;
    }




    public void setSumActInstantPower(PropertyValueDBEmbeddable sumActInstantPower) {
        this.sumActInstantPower = sumActInstantPower;
    }




    public PropertyValueDBEmbeddable getInstCurr_l1() {
        return instCurr_l1;
    }




    public void setInstCurr_l1(PropertyValueDBEmbeddable instCurr_l1) {
        this.instCurr_l1 = instCurr_l1;
    }




    public PropertyValueDBEmbeddable getInstVolt_l1() {
        return instVolt_l1;
    }




    public void setInstVolt_l1(PropertyValueDBEmbeddable instVolt_l1) {
        this.instVolt_l1 = instVolt_l1;
    }




    public PropertyValueDBEmbeddable getInstCurr_l2() {
        return instCurr_l2;
    }




    public void setInstCurr_l2(PropertyValueDBEmbeddable instCurr_l2) {
        this.instCurr_l2 = instCurr_l2;
    }




    public PropertyValueDBEmbeddable getInstVolt_l2() {
        return instVolt_l2;
    }




    public void setInstVolt_l2(PropertyValueDBEmbeddable instVolt_l2) {
        this.instVolt_l2 = instVolt_l2;
    }




    public PropertyValueDBEmbeddable getInstCurr_l3() {
        return instCurr_l3;
    }




    public void setInstCurr_l3(PropertyValueDBEmbeddable instCurr_l3) {
        this.instCurr_l3 = instCurr_l3;
    }




    public PropertyValueDBEmbeddable getInstVolt_l3() {
        return instVolt_l3;
    }




    public void setInstVolt_l3(PropertyValueDBEmbeddable instVolt_l3) {
        this.instVolt_l3 = instVolt_l3;
    }

    public UUID getMeterId() {
        return meterDBEntity.getId();
    }

    
    public void setMeterDBEntity(MeterDBEntity meterDBEntity) {
        this.meterDBEntity = meterDBEntity;
    }


    public MeterDBEntity getMeterDBEntity() {
        return meterDBEntity;
    }

    
}
