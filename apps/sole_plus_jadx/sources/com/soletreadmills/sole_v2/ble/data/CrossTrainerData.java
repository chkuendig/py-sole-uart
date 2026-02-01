package com.soletreadmills.sole_v2.ble.data;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class CrossTrainerData extends FtmsBaseData {
    private Double instantaneousSpeed = null;
    private Double averageSpeed = null;
    private Integer totalDistance = null;
    private Double stepPerMinute = null;
    private Double averageStepRate = null;
    private Integer strideCount = null;
    private Double positiveElevationGain = null;
    private Double negativeElevationGain = null;
    private Double inclination = null;
    private Double rampAngleSetting = null;
    private Integer resistanceLevel = null;
    private Integer instantaneousPower = null;
    private Integer averagePower = null;
    private MovementDirectionType movementDirection = null;

    public enum MovementDirectionType {
        FORWARD,
        BACKWARD
    }

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

    public Integer getStrideCount() {
        return this.strideCount;
    }

    public void setStrideCount(Integer strideCount) {
        this.strideCount = strideCount;
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

    public Double getInclination() {
        return this.inclination;
    }

    public void setInclination(Double inclination) {
        this.inclination = inclination;
    }

    public Double getRampAngleSetting() {
        return this.rampAngleSetting;
    }

    public void setRampAngleSetting(Double rampAngleSetting) {
        this.rampAngleSetting = rampAngleSetting;
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

    public MovementDirectionType getMovementDirection() {
        return this.movementDirection;
    }

    public void setMovementDirection(MovementDirectionType movementDirection) {
        this.movementDirection = movementDirection;
    }

    public String toString() {
        return "CrossTrainerData{\n createDate=" + this.createDate + "\n bleName='" + this.bleName + "\n macAddress='" + this.macAddress + "\n instantaneousSpeed=" + this.instantaneousSpeed + "\n averageSpeed=" + this.averageSpeed + "\n totalDistance=" + this.totalDistance + "\n stepPerMinute=" + this.stepPerMinute + "\n averageStepRate=" + this.averageStepRate + "\n strideCount=" + this.strideCount + "\n positiveElevationGain=" + this.positiveElevationGain + "\n negativeElevationGain=" + this.negativeElevationGain + "\n Inclination=" + this.inclination + "\n rampAngleSetting=" + this.rampAngleSetting + "\n resistanceLevel=" + this.resistanceLevel + "\n instantaneousPower=" + this.instantaneousPower + "\n averagePower=" + this.averagePower + "\n totalEnergy=" + this.totalEnergy + "\n energyPerHour=" + this.energyPerHour + "\n energyPerMinute=" + this.energyPerMinute + "\n heartRate=" + this.heartRate + "\n metabolicEquivalent=" + this.metabolicEquivalent + "\n elapsedTime=" + this.elapsedTime + "\n remainingTime=" + this.remainingTime + "\n movementDirection=" + this.movementDirection + "\nclassId=" + this.classId + "\nclassType=" + this.classType + "\nclassName=" + this.className + AbstractJsonLexerKt.END_OBJ;
    }
}
