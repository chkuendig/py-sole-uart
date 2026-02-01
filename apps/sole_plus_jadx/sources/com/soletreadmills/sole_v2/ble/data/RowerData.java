package com.soletreadmills.sole_v2.ble.data;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class RowerData extends FtmsBaseData {
    private Double strokeRate = null;
    private Integer strokeCount = null;
    private Double averageStrokeRate = null;
    private Integer totalDistance = null;
    private Double instantaneousPace = null;
    private Double averagePace = null;
    private Integer instantaneousPower = null;
    private Integer averagePower = null;
    private Integer resistanceLevel = null;

    public Double getStrokeRate() {
        return this.strokeRate;
    }

    public void setStrokeRate(Double strokeRate) {
        this.strokeRate = strokeRate;
    }

    public Integer getStrokeCount() {
        return this.strokeCount;
    }

    public void setStrokeCount(Integer strokeCount) {
        this.strokeCount = strokeCount;
    }

    public Double getAverageStrokeRate() {
        return this.averageStrokeRate;
    }

    public void setAverageStrokeRate(Double averageStrokeRate) {
        this.averageStrokeRate = averageStrokeRate;
    }

    public Integer getTotalDistance() {
        return this.totalDistance;
    }

    public void setTotalDistance(Integer totalDistance) {
        this.totalDistance = totalDistance;
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

    public Integer getResistanceLevel() {
        return this.resistanceLevel;
    }

    public void setResistanceLevel(Integer resistanceLevel) {
        this.resistanceLevel = resistanceLevel;
    }

    public String toString() {
        return "RowerData{\n createDate=" + this.createDate + "\n bleName='" + this.bleName + "\n macAddress='" + this.macAddress + "\n strokeRate=" + this.strokeRate + "\n strokeCount=" + this.strokeCount + "\n averageStrokeRate=" + this.averageStrokeRate + "\n totalDistance=" + this.totalDistance + "\n instantaneousPace=" + this.instantaneousPace + "\n averagePace=" + this.averagePace + "\n instantaneousPower=" + this.instantaneousPower + "\n averagePower=" + this.averagePower + "\n resistanceLevel=" + this.resistanceLevel + "\n totalEnergy=" + this.totalEnergy + "\n energyPerHour=" + this.energyPerHour + "\n energyPerMinute=" + this.energyPerMinute + "\n heartRate=" + this.heartRate + "\n metabolicEquivalent=" + this.metabolicEquivalent + "\n elapsedTime=" + this.elapsedTime + "\n remainingTime=" + this.remainingTime + "\nclassId=" + this.classId + "\nclassType=" + this.classType + "\nclassName=" + this.className + AbstractJsonLexerKt.END_OBJ;
    }
}
