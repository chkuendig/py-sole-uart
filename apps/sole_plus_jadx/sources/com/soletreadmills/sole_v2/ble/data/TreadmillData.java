package com.soletreadmills.sole_v2.ble.data;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class TreadmillData extends FtmsBaseData {
    private Double instantaneousSpeed = null;
    private Double averageSpeed = null;
    private Integer totalDistance = null;
    private Double Inclination = null;
    private Double rampAngleSetting = null;
    private Double positiveElevationGain = null;
    private Double negativeElevationGain = null;
    private Double instantaneousPace = null;
    private Double averagePace = null;
    private Integer forceOnBelt = null;
    private Integer powerOutput = null;

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

    public Integer getTotalDistance() {
        return this.totalDistance;
    }

    public void setTotalDistance(Integer totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Double getInclination() {
        return this.Inclination;
    }

    public void setInclination(Double inclination) {
        this.Inclination = inclination;
    }

    public Double getRampAngleSetting() {
        return this.rampAngleSetting;
    }

    public void setRampAngleSetting(Double rampAngleSetting) {
        this.rampAngleSetting = rampAngleSetting;
    }

    public Double getPositiveElevationGain() {
        return this.positiveElevationGain;
    }

    public void setPositiveElevationGain(Double positiveElevationGain) {
        this.positiveElevationGain = positiveElevationGain;
    }

    public Double getNegativeElevationGain() {
        return this.negativeElevationGain;
    }

    public void setNegativeElevationGain(Double negativeElevationGain) {
        this.negativeElevationGain = negativeElevationGain;
    }

    public Double getInstantaneousPace() {
        return this.instantaneousPace;
    }

    public void setInstantaneousPace(Double instantaneousPace) {
        this.instantaneousPace = instantaneousPace;
    }

    public Double getAveragePace() {
        return this.averagePace;
    }

    public void setAveragePace(Double averagePace) {
        this.averagePace = averagePace;
    }

    public Integer getForceOnBelt() {
        return this.forceOnBelt;
    }

    public void setForceOnBelt(Integer forceOnBelt) {
        this.forceOnBelt = forceOnBelt;
    }

    public Integer getPowerOutput() {
        return this.powerOutput;
    }

    public void setPowerOutput(Integer powerOutput) {
        this.powerOutput = powerOutput;
    }

    public String toString() {
        return "TreadmillData{\ncreateDate=" + this.createDate + "\nbleName=" + this.bleName + ", \ninstantaneousSpeed=" + this.instantaneousSpeed + ", \naverageSpeed=" + this.averageSpeed + ", \ntotalDistance=" + this.totalDistance + ", \nInclination=" + this.Inclination + ", \nrampAngleSetting=" + this.rampAngleSetting + ", \npositiveElevationGain=" + this.positiveElevationGain + ", \nnegativeElevationGain=" + this.negativeElevationGain + ", \ninstantaneousPace=" + this.instantaneousPace + ", \naveragePace=" + this.averagePace + ", \ntotalEnergy=" + this.totalEnergy + ", \nenergyPerHour=" + this.energyPerHour + ", \nenergyPerMinute=" + this.energyPerMinute + ", \nheartRate=" + this.heartRate + ", \nmetabolicEquivalent=" + this.metabolicEquivalent + ", \nelapsedTime=" + this.elapsedTime + ", \nremainingTime=" + this.remainingTime + ", \nforceOnBelt=" + this.forceOnBelt + ", \npowerOutput=" + this.powerOutput + ", \nclassId=" + this.classId + ", \nclassType=" + this.classType + ", \nclassName=" + this.className + AbstractJsonLexerKt.END_OBJ;
    }
}
