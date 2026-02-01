package com.dyaco.ideabussdk_sole.protocol;

/* loaded from: classes.dex */
public class WorkoutData {
    private float calHour;
    private int calRemaining;
    private float calSeconds;
    private float calories;
    private float distance;
    private int fusion_interval_time;
    private int fusion_recovery_time;
    private int heart_rate;
    private int hr_type;
    private boolean isAutoConnectedSimulationData = false;
    private int laps;
    private float mets;
    private int minute;
    private int nowIncline;
    private int nowLevel;
    private int nowTargetHR;
    private int pace;
    private String paceMinute;
    private String paceSeconds;
    private int program_height;
    private int program_row;
    private int rpm;
    private int seconds;
    private float speed;
    private int spm;
    private int total_steps;
    private int vert;
    private int watt;

    public void setMinute(int i) {
        this.minute = i;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setSeconds(int i) {
        this.seconds = i;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void setDistance(float f) {
        this.distance = f;
    }

    public float getDistance() {
        return this.distance;
    }

    public void setCalories(float f) {
        this.calories = f;
    }

    public float getCalories() {
        return this.calories;
    }

    public void setHeartRate(int i) {
        this.heart_rate = i;
    }

    public int getHeartRate() {
        return this.heart_rate;
    }

    public void setRpm(int i) {
        this.rpm = i;
    }

    public int getRpm() {
        return this.rpm;
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setNowLevel(int i) {
        this.nowLevel = i;
    }

    public int getNowLevel() {
        return this.nowLevel;
    }

    public void setNowIncline(int i) {
        this.nowIncline = i;
    }

    public int getNowIncline() {
        return this.nowIncline;
    }

    public void setNowTargetHR(int i) {
        this.nowTargetHR = i;
    }

    public int getNowTargetHR() {
        return this.nowTargetHR;
    }

    public void setWatt(int i) {
        this.watt = i;
    }

    public int getWatt() {
        return this.watt;
    }

    public void setMets(float f) {
        this.mets = f;
    }

    public float getMets() {
        return this.mets;
    }

    public void setHrType(int i) {
        this.hr_type = i;
    }

    public int getHrType() {
        return this.hr_type;
    }

    public void setFusionIntervalTime(int i) {
        this.fusion_interval_time = i;
    }

    public int getFusionIntervalTime() {
        return this.fusion_interval_time;
    }

    public void setFusionRecoveryTime(int i) {
        this.fusion_recovery_time = i;
    }

    public int getFusionRecoveryTime() {
        return this.fusion_recovery_time;
    }

    public int getProgramRow() {
        return this.program_row;
    }

    public void setProgramRow(int i) {
        this.program_row = i;
    }

    public int getProgramHeight() {
        return this.program_height;
    }

    public void setProgramHeight(int i) {
        this.program_height = i;
    }

    public int getLaps() {
        return this.laps;
    }

    public void setLaps(int i) {
        this.laps = i;
    }

    public String getPaceMinute() {
        return this.paceMinute;
    }

    public void setPaceMinute(String str) {
        this.paceMinute = str;
    }

    public String getPaceSeconds() {
        return this.paceSeconds;
    }

    public void setPaceSeconds(String str) {
        this.paceSeconds = str;
    }

    public int getCalRemaining() {
        return this.calRemaining;
    }

    public void setCalRemaining(int i) {
        this.calRemaining = i;
    }

    public float getCalHour() {
        return this.calHour;
    }

    public void setCalHour(float f) {
        this.calHour = f;
    }

    public float getCalSeconds() {
        return this.calSeconds;
    }

    public void setCalSeconds(float f) {
        this.calSeconds = f;
    }

    public int getSpm() {
        return this.spm;
    }

    public void setSpm(int i) {
        this.spm = i;
    }

    public int getTotalSteps() {
        return this.total_steps;
    }

    public void setTotalSteps(int i) {
        this.total_steps = i;
    }

    public int getVert() {
        return this.vert;
    }

    public void setVert(int i) {
        this.vert = i;
    }

    public void setAutoConnectedSimulationData(boolean z) {
        this.isAutoConnectedSimulationData = z;
    }

    public boolean isAutoConnectedSimulationData() {
        return this.isAutoConnectedSimulationData;
    }

    public String toString() {
        return "WorkoutData{minute=" + this.minute + ", seconds=" + this.seconds + ", distance=" + this.distance + ", calories=" + this.calories + ", heart_rate=" + this.heart_rate + ", rpm=" + this.rpm + ", speed=" + this.speed + ", nowLevel=" + this.nowLevel + ", nowIncline=" + this.nowIncline + ", nowTargetHR=" + this.nowTargetHR + ", watt=" + this.watt + ", mets=" + this.mets + ", hr_type=" + this.hr_type + ", fusion_interval_time=" + this.fusion_interval_time + ", fusion_recovery_time=" + this.fusion_recovery_time + ", program_row=" + this.program_row + ", program_height=" + this.program_height + ", laps=" + this.laps + ", pace=" + this.pace + ", paceMinute='" + this.paceMinute + "', paceSeconds='" + this.paceSeconds + "', calRemaining=" + this.calRemaining + ", calHour=" + this.calHour + ", calSeconds=" + this.calSeconds + ", spm=" + this.spm + ", total_steps=" + this.total_steps + ", vert=" + this.vert + '}';
    }
}
