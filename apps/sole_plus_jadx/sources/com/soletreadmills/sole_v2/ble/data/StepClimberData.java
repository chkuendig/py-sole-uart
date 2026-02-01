package com.soletreadmills.sole_v2.ble.data;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class StepClimberData extends FtmsBaseData {
    private Integer floors = null;
    private Integer stepCount = null;
    private Double stepPerMinute = null;
    private Double averageStepRate = null;
    private Integer positiveElevationGain = null;
    private Integer resistanceLevel = null;

    public Integer getFloors() {
        return this.floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public Integer getStepCount() {
        return this.stepCount;
    }

    public void setStepCount(Integer stepCount) {
        this.stepCount = stepCount;
    }

    public Double getStepPerMinute() {
        return this.stepPerMinute;
    }

    public void setStepPerMinute(Double stepPerMinute) {
        this.stepPerMinute = stepPerMinute;
    }

    public Double getAverageStepRate() {
        return this.averageStepRate;
    }

    public void setAverageStepRate(Double averageStepRate) {
        this.averageStepRate = averageStepRate;
    }

    public Integer getPositiveElevationGain() {
        return this.positiveElevationGain;
    }

    public void setPositiveElevationGain(Integer positiveElevationGain) {
        this.positiveElevationGain = positiveElevationGain;
    }

    public Integer getResistanceLevel() {
        return this.resistanceLevel;
    }

    public void setResistanceLevel(Integer resistanceLevel) {
        this.resistanceLevel = resistanceLevel;
    }

    public String toString() {
        return "StepClimberData{\n createDate=" + this.createDate + "\n bleName='" + this.bleName + "\n macAddress='" + this.macAddress + "\n floors=" + this.floors + "\n stepCount=" + this.stepCount + "\n stepPerMinute=" + this.stepPerMinute + "\n averageStepRate=" + this.averageStepRate + "\n positiveElevationGain=" + this.positiveElevationGain + "\n resistanceLevel=" + this.resistanceLevel + "\n totalEnergy=" + this.totalEnergy + "\n energyPerHour=" + this.energyPerHour + "\n energyPerMinute=" + this.energyPerMinute + "\n heartRate=" + this.heartRate + "\n metabolicEquivalent=" + this.metabolicEquivalent + "\n elapsedTime=" + this.elapsedTime + "\n remainingTime=" + this.remainingTime + "\nclassId=" + this.classId + "\nclassType=" + this.classType + "\nclassName=" + this.className + AbstractJsonLexerKt.END_OBJ;
    }
}
