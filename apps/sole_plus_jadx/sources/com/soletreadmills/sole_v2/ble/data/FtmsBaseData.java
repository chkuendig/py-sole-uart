package com.soletreadmills.sole_v2.ble.data;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2.ble.type.FitnessMachineStatusType;
import java.util.Date;

/* loaded from: classes5.dex */
public class FtmsBaseData {
    protected FitnessMachineStatusType fitnessMachineStatusType;
    protected final Date createDate = new Date();
    protected String bleName = "";
    protected String macAddress = null;
    protected Integer totalEnergy = null;
    protected Integer energyPerHour = null;
    protected Integer energyPerMinute = null;
    protected Integer heartRate = null;
    protected Double metabolicEquivalent = null;
    protected Integer elapsedTime = null;
    protected Integer remainingTime = null;

    @SerializedName("class_id")
    protected String classId = null;

    @SerializedName("class_type")
    protected String classType = null;

    @SerializedName("class_name")
    protected String className = null;

    public Date getCreateDate() {
        return this.createDate;
    }

    public String getBleName() {
        return this.bleName;
    }

    public void setBleName(String bleName) {
        this.bleName = bleName;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Integer getTotalEnergy() {
        return this.totalEnergy;
    }

    public void setTotalEnergy(Integer totalEnergy) {
        this.totalEnergy = totalEnergy;
    }

    public Integer getEnergyPerHour() {
        return this.energyPerHour;
    }

    public void setEnergyPerHour(Integer energyPerHour) {
        this.energyPerHour = energyPerHour;
    }

    public Integer getEnergyPerMinute() {
        return this.energyPerMinute;
    }

    public void setEnergyPerMinute(Integer energyPerMinute) {
        this.energyPerMinute = energyPerMinute;
    }

    public Integer getHeartRate() {
        return this.heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public Double getMetabolicEquivalent() {
        return this.metabolicEquivalent;
    }

    public void setMetabolicEquivalent(Double metabolicEquivalent) {
        this.metabolicEquivalent = metabolicEquivalent;
    }

    public Integer getElapsedTime() {
        return this.elapsedTime;
    }

    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public Integer getRemainingTime() {
        return this.remainingTime;
    }

    public void setRemainingTime(Integer remainingTime) {
        this.remainingTime = remainingTime;
    }

    public String getClassId() {
        return this.classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassType() {
        return this.classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public FitnessMachineStatusType getFitnessMachineStatusType() {
        return this.fitnessMachineStatusType;
    }

    public void setFitnessMachineStatusType(FitnessMachineStatusType fitnessMachineStatusType) {
        this.fitnessMachineStatusType = fitnessMachineStatusType;
    }
}
