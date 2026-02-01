package com.soletreadmills.sole_v2.ble.data;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class IndoorBikeData extends FtmsBaseData {
    private Double instantaneousSpeed = null;
    private Double averageSpeed = null;
    private Double instantaneousCadence = null;
    private Double averageCadence = null;
    private Integer totalDistance = null;
    private Integer resistanceLevel = null;
    private Integer instantaneousPower = null;
    private Integer averagePower = null;
    private Double inclination = null;

    public Double getInstantaneousSpeed() {
        return this.instantaneousSpeed;
    }

    public void setInstantaneousSpeed(Double instantaneousSpeed) {
        this.instantaneousSpeed = instantaneousSpeed;
    }

    public Double getAverageSpeed() {
        return this.averageSpeed;
    }

    public void setAverageSpeed(Double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public Double getInstantaneousCadence() {
        return this.instantaneousCadence;
    }

    public void setInstantaneousCadence(Double instantaneousCadence) {
        this.instantaneousCadence = instantaneousCadence;
    }

    public Double getAverageCadence() {
        return this.averageCadence;
    }

    public void setAverageCadence(Double averageCadence) {
        this.averageCadence = averageCadence;
    }

    public Integer getTotalDistance() {
        return this.totalDistance;
    }

    public void setTotalDistance(Integer totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Integer getResistanceLevel() {
        return this.resistanceLevel;
    }

    public void setResistanceLevel(Integer resistanceLevel) {
        this.resistanceLevel = resistanceLevel;
    }

    public Integer getInstantaneousPower() {
        return this.instantaneousPower;
    }

    public void setInstantaneousPower(Integer instantaneousPower) {
        this.instantaneousPower = instantaneousPower;
    }

    public Integer getAveragePower() {
        return this.averagePower;
    }

    public void setAveragePower(Integer averagePower) {
        this.averagePower = averagePower;
    }

    public Double getInclination() {
        return this.inclination;
    }

    public void setInclination(Double inclination) {
        this.inclination = inclination;
    }

    public String toString() {
        return "IndoorBikeData{,\ncreateDate=" + this.createDate + ",\nbleName=" + this.bleName + ",\nmacAddress=" + this.macAddress + ",\ninstantaneousSpeed=" + this.instantaneousSpeed + ",\naverageSpeed=" + this.averageSpeed + ",\ninstantaneousCadence=" + this.instantaneousCadence + ",\naverageCadence=" + this.averageCadence + ",\ntotalDistance=" + this.totalDistance + ",\nresistanceLevel=" + this.resistanceLevel + ",\ninstantaneousPower=" + this.instantaneousPower + ",\naveragePower=" + this.averagePower + ",\ntotalEnergy=" + this.totalEnergy + ",\nenergyPerHour=" + this.energyPerHour + ",\nenergyPerMinute=" + this.energyPerMinute + ",\nheartRate=" + this.heartRate + ",\nmetabolicEquivalent=" + this.metabolicEquivalent + ",\nelapsedTime=" + this.elapsedTime + ",\nremainingTime=" + this.remainingTime + "\nclassId=" + this.classId + "\nclassType=" + this.classType + "\nclassName=" + this.className + "\n Inclination=" + this.inclination + AbstractJsonLexerKt.END_OBJ;
    }
}
